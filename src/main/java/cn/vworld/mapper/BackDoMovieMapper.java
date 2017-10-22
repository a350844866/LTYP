package cn.vworld.mapper;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;

import java.util.List;

public interface BackDoMovieMapper {
    public MovieInfo findMovieInfoByMovieId(String movieId);

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

    void deleteMovieInfoByMovieIds(String[] movieIds);

    void deleteMovieImageByMovieIds(String[] movieIds);
}
