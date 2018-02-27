package cn.vworld.mapper;

import cn.vworld.bean.Type;
import cn.vworld.bean.TypeAndCount;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author jiaxu
 * @version $Id: ${FILE_NAME}, v 0.1 2018/1/31 15:13 jiaxu Exp $$
 */
public interface TypeMapper {
    /**
     * 查找类型名和数量的对象
     *
     * @return
     */
    List<TypeAndCount> getTypeNameAndCountMap();

    /**
     * 根据类型id来查找类型名称
     *
     * @param typeId
     * @return
     */
    String selectTypeNameByTypeId(String typeId);

    /**
     * 查找所有类型
     *
     * @return
     */
    List<Type> selectAllType();
}
