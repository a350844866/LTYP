package cn.vworld.mapper;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;

import java.util.List;

public interface BackDoMovieMapper {


    /**
     * 通过movieId来查找图片信息
     *
     * @param movieId
     * @return
     */
    List<MovieImage> findMovieImageByMovieId(String movieId);

    /**
     * 修改提交后的入库操作，需要先将对应movieId的MovieInfo删除
     *
     * @param movieId
     */
    void deleteMovieInfoByMovieId(String movieId);

    /**
     * 修改提交前，先根据movieID删除movieImage实例
     *
     * @param movieId
     */
    void deleteMovieImageByMovieId(String movieId);

    /**
     * 通过movieId数组来删除电影信息
     *
     * @param movieIds
     */
    void deleteMovieInfoByMovieIds(String[] movieIds);

    /**
     * 通过movieId数组来删除电影图片
     *
     * @param movieIds
     */
    void deleteMovieImageByMovieIds(String[] movieIds);
}
