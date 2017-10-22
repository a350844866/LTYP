package cn.vworld.service.backservice;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;

import java.util.List;

public interface BackDoMovieService {
    public MovieInfo findMovieInfoByMovieId(String movieId);

    List<MovieImage> findMovieImageByMovieId(String movieId);

    /**
     * 修改前先把movieInfo实例删除
     *
     * @param movieId
     */
    void deleteMovieInfoByMovieId(String movieId);

    /**
     * 修改前也需要将movieImage实例删除
     *
     * @param movieId
     */
    void deleteMovieImageByMovieId(String movieId);

    void deleteMovieInfoByMovieIds(String[] movieIds);

    void deleteMovieImageByMovieIds(String[] movieIds);
}
