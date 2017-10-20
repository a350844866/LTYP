package cn.vworld.mapper;

import cn.vworld.bean.MovieInfo;

import java.util.ArrayList;

public interface MovieMapper {

    ArrayList<MovieInfo> findfirstfourMovie(Integer page);

    ArrayList<MovieInfo> findsecondfourMovie(Integer page);

    ArrayList<MovieInfo> findthirdfourMovie(Integer page);

    Integer findMovieNum();
}
