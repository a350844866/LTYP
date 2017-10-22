package cn.vworld.service;

import cn.vworld.bean.Comment;
import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;

import java.util.ArrayList;
import java.util.List;

public interface MovieService {


    /**
     * 查找第一行的电影
     * @param page 当前页码
     * @return 第一行的电影对象集合
     */
    ArrayList<MovieInfo> findfirstfourMovie(Integer page, Integer rowNum);

    /**
     * 查找第二行的电影
     * @param page 当前页码
     * @return 第二行的电影对象集合
     */
    ArrayList<MovieInfo> findsecondfourMovie(Integer page, Integer rowNum);

    /**
     * 查找第三行的电影
     * @param page 当前页面
     * @return 第三行的电影对象集合
     */
    ArrayList<MovieInfo> findthirdfourMovie(Integer page, Integer rowNum);

    /**
     * 查找一共有多少部电影
     * @return 电影的数量
     */
    Integer findMovieNum();

    /**
     * 通过movieInfoid来查找movieInfo对象
     * @param movieInfoId movieInfo的id
     * @return 返回的是movieInfo对象
     */
    MovieInfo findMovieInfoByMovieInfoId(String movieInfoId);

    /**
     * 通过movieInfoId来查找movieImage表上的内容
     * @param movieInfoId movieInfo的id
     * @return 返回查找到的movie_image对象集合
     */
    List<MovieImage> findMovieImageByMovieInfoId(String movieInfoId);

    /**
     * 根据电影ID来寻找评论
     *
     * @param movieInfoId 电影id
     * @return 返回评论集合
     */
    List<Comment> findCommentsByMovie(String movieInfoId);

    /**
     * 插入评论
     * @param comment 评论对象
     */
    void insertComment(Comment comment);

    /**
     * 通过输入框内容来进行电影查询
     *
     * @param search 搜索框的内容
     * @return 电影集合
     */
    List<MovieInfo> findMovieListBySearch(String search);

    /**
     * 查找最近更新的电影
     *
     * @param number 选择最近的更新的电影数量
     * @return 返回最近更新的电影集合
     */
    List<MovieInfo> findNewUpdateMovie(Integer number);

    /**
     * 根据类型查找电影
     *
     * @param typeId 电影类型的id
     * @return 电影的列表
     */
    List<MovieInfo> typeSearch(String typeId);

    /**
     * 根据类型查找电影的数量
     *
     * @param search 关键词
     */
    Integer findMovieNumBySearch(String search);

    /**
     * 根据搜索结果的数据进行分页查询操作
     *
     * @param page            当前页码
     * @param resultPageMovie 每页分页的数量
     * @return 查询到的电影列表
     */
    List<MovieInfo> limitMovieListBySearch(String search, Integer page, Integer resultPageMovie);

    /**
     * 根据类型查询电影数量
     *
     * @param typeId 电影类型的id
     * @return 查询到的电影数量
     */
    Integer typeSearchCount(String typeId);

    List<MovieInfo> limitTypeSearch(String typeId, int i, Integer resultPageMovie);

    Boolean isScoreExist(String userId, String movieId);

    void insertScore(String userId, String movieId, String score);

    Double getAvgScore(String movieId);

    void updateScore(String movieId, Double avgScore);
}
