package cn.vworld.mapper;

import cn.vworld.bean.TypeAndCount;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author jiaxu
 * @version $Id: ${FILE_NAME}, v 0.1 2018/1/31 15:13 jiaxu Exp $$
 */
public interface TypeMapper {
    List<TypeAndCount> getTypeNameAndCountMap();
}
