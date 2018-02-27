package cn.vworld.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiaxu
 * @version $Id: MovieTypeMapper.java, v 0.1 2018/2/26 17:20 jiaxu Exp $$
 */
public interface MovieTypeMapper {
    /**
     * 插入电影类型关联
     *
     * @param movieId
     * @param typeId
     */
    void insert(@Param("movieId") String movieId, @Param("typeId") int typeId);

    /**
     * 根据电影id来查找类型id
     *
     * @param movieId
     * @return
     */
    List<String> selectTypeIdByMovieId(String movieId);

    /**
     * 根据movieId来删除movieType
     *
     * @param movieId
     */
    void deleteMovieTypeByMovieId(String movieId);
}
