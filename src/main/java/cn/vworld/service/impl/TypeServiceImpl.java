package cn.vworld.service.impl;

import cn.vworld.bean.Type;
import cn.vworld.bean.TypeAndCount;
import cn.vworld.mapper.TypeMapper;
import cn.vworld.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<TypeAndCount> getTypeNameAndCountMap() {
        return typeMapper.getTypeNameAndCountMap();
    }
}
