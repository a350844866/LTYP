package cn.vworld.service.backservice;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;

import java.util.List;

public interface BackDoMovieService {
    /**
     * 根据id查询电影信息
     *
     * @param movieId
     * @return
     */
    public MovieInfo findMovieInfoByMovieId(String movieId);

    /**
     * 根据id查询电影图片
     * @param movieId
     * @return
     */
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

    /**
     * 根据id数组删除电影细腻
     * @param movieIds
     */
    void deleteMovieInfoByMovieIds(String[] movieIds);

    /**
     * 根据电影id删除电影图片
     * @param movieIds
     */
    void deleteMovieImageByMovieIds(String[] movieIds);
}
