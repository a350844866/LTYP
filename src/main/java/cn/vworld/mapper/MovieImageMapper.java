package cn.vworld.mapper;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;

import java.util.List;

public interface MovieImageMapper {
    List<MovieImage> findMovieImageByMovieInfoId(String movieInfoId);
}
