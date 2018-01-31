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
    List<TypeAndCount> getTypeNameAndCountMap();
}
