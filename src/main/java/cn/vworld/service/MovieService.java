package cn.vworld.service;

import cn.vworld.bean.MovieInfo;

import java.util.ArrayList;

public interface MovieService {


    /**
     * 查找第一行的电影
     * @param page 当前页码
     * @return 第一行的电影对象集合
     */
    ArrayList<MovieInfo> findfirstfourMovie(Integer page);

    /**
     * 查找第二行的电影
     * @param page 当前页码
     * @return 第二行的电影对象集合
     */
    ArrayList<MovieInfo> findsecondfourMovie(Integer page);

    /**
     * 查找第三行的电影
     * @param page 当前页面
     * @return 第三行的电影对象集合
     */
    ArrayList<MovieInfo> findthirdfourMovie(Integer page);

    /**
     * 查找一共有多少部电影
     * @return 电影的数量
     */
    Integer findMovieNum();
}
