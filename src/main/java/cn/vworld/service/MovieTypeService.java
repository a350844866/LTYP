package cn.vworld.service;

import java.util.List;

/**
 * @author jiaxu
 * @version $Id: MovieTypeService.java, v 0.1 2018/2/26 18:22 jiaxu Exp $$
 */
public interface MovieTypeService {

    /**
     * 通过电影id来查找类型id
     *
     * @param movieId
     * @return
     */
    List<String> selectTypeIdByMovieId(String movieId);

    /**
     * 通过movieId来删除movieType表中的数据
     *
     * @param movieId
     */
    void deleteMovieTypeByMovieId(String movieId);
}
