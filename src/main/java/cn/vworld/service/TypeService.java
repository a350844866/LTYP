package cn.vworld.service;

import cn.vworld.bean.Type;
import cn.vworld.bean.TypeAndCount;

import java.util.List;
import java.util.Map;

/**
 * @author jiaxu
 * @version $Id: ${FILE_NAME}, v 0.1 2018/1/31 15:10 jiaxu Exp $$
 */
public interface TypeService {
    /**
     * 得到所有的电影类型和数量的对象
     *
     * @return
     */
    List<TypeAndCount> getTypeNameAndCountMap();

    /**
     * 根据类型id来查询类型名称
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
    List<Type> getAllType();
}
