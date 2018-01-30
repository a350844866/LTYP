package cn.vworld.mapper;

import cn.vworld.bean.MovieInfo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface MovieMapper {

    ArrayList<MovieInfo> findfirstfourMovie(@Param("page") Integer page, @Param("rowNum") Integer rowNum);

    ArrayList<MovieInfo> findsecondfourMovie(@Param("page") Integer page, @Param("rowNum") Integer rowNum);

    ArrayList<MovieInfo> findthirdfourMovie(@Param("page") Integer page, @Param("rowNum") Integer rowNum);

    Integer findMovieNum();

    MovieInfo findMovieInfoByMovieInfoId(String movieInfoId);

    List<MovieInfo> findMovieListBySearch(String search);

    List<MovieInfo> findNewUpdateMovie(Integer number);

    List<MovieInfo> typeSearch(String typeId);

    Integer findMovieNumBySearch(String search);

    List<MovieInfo> limitMovieListBySearch(@Param("search") String search, @Param("page") Integer page, @Param("resultPageMovie") Integer resultPageMovie);

    Integer typeSearchCount(String typeId);

    List<MovieInfo> limitTypeSearch(@Param("typeId") String typeId, @Param("page") int page, @Param("resultPageMovie") Integer resultPageMovie);

    void updateScore(@Param("movieId") String movieId, @Param("avgscore") Double avgscore);
}
