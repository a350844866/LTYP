package cn.vworld.service.backservice;

import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.User;

import java.util.List;

public interface BackendMovieService {

    /** 查看电影数量总数 */
    public Integer findMovieNum();

    /** 查看电影类型总量 */
    public Integer findMovieTypeNum();

    /** 查询所有的用户数量 */
    public Integer findUserNum();

    /**
     * 查询所有的电影
     * @return 电影集合
     */
    List<MovieInfo> findAllMovie();

    /**
     * 查询所有的电影类型
     * @return 电影类型集合
     */
    List<Type> findAllMovieType();

    // 通过评论总量去选取5个最活跃的用户
    List<User> findUserByCommentNum();

    // 查询当前要的数据
    List<MovieInfo> findMovieList(int showpage, int lines);

    // 存储电影信息
    public void saveMovie(MovieInfo movieInfo,String[] xqpath);


}
