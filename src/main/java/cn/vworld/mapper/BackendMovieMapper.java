package cn.vworld.mapper;

import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackendMovieMapper {

    //查询电影总量
    public Integer findMovieNum();

    //查询电影分类总量
    public Integer findMovieTypeNum();

    //查询用户总量
    public Integer findUserNum();

    //查询所有的movie——info
    List<MovieInfo> findAllMovie();

    //查询出所有的Type类型
    List<Type> finAllMovieType();

    //通过评论的数量去选择最多评论的五个人
    List<User> findUserByCommentNum();

     //查询当前页所要的数据
    List<MovieInfo> findMovieList(@Param("showpage") int showpage, @Param("lines") int lines);

    public void saveMovie(MovieInfo movieInfo);
}
