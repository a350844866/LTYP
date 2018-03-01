package cn.vworld.service.impl;

import cn.vworld.bean.Type;
import cn.vworld.bean.TypeAndCount;
import cn.vworld.mapper.TypeMapper;
import cn.vworld.service.TypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author jiaxu
 * @version $Id: ${FILE_NAME}, v 0.1 2018/1/31 15:11 jiaxu Exp $$
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private JedisPool jedisPool;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<TypeAndCount> getTypeNameAndCountMap() {
        return typeMapper.getTypeNameAndCountMap();
    }

    /**
     * 根据类型id来查询类型名称
     *
     * @param typeId
     * @return
     */
    @Override
    public String selectTypeNameByTypeId(String typeId) {
        return typeMapper.selectTypeNameByTypeId(typeId);
    }

    /**
     * 查找所有类型
     *
     * @return
     */
    @Override
    public List<Type> getAllType() {
        Jedis jedis = jedisPool.getResource();
        String alltype = jedis.get("LTYP_ALLTYPE");
        if (alltype != null) {
            try {
                List<Type> typeList = Arrays.asList(objectMapper.readValue(alltype, Type[].class));
                return typeList;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (jedis != null) {
                    jedisPool.returnResource(jedis);
                }
            }
        }
        try {
            List<Type> typeList = typeMapper.selectAllType();
            String json = objectMapper.writeValueAsString(typeList);
            jedis.set("LTYP_ALLTYPE", json);
            return typeList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }
        return typeMapper.selectAllType();
    }
}
