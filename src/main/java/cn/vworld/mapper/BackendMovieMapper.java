package cn.vworld.mapper;

import cn.vworld.bean.MovieImage;
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

    /**
     * 保存电影信息
     *
     * @param movieInfo
     */
    public void saveMovie(MovieInfo movieInfo);

    // 根据评论总量选择排名前五的电影
    List<MovieInfo> findFiveMovie();

    /**
     * 入库电影详情页电影图片
     * @param movieImage
     */
    void saveMoviexqPath(MovieImage movieImage);

    /**
     * 插入数据前再删除，空的海报路径
     * @param imageId
     */
    void deleteNullPosterUrl(String imageId);

    /**
     *
     * @param key
     * @return
     */
    int findMovieByKey(String key);

    /**
     * 根据关键词分页查找电影
     * @param showpage
     * @param lines
     * @param key
     * @return
     */
    List<MovieInfo> findMovieListBykey(@Param("showpage") int showpage, @Param("lines") int lines, @Param("key") String key);

    /**
     * 根据平均分进行排序的电影集合
     *
     * @param showpage
     * @param lines
     * @return
     */
    List<MovieInfo> findMovieListOrderByAvgScore(@Param("showpage") int showpage, @Param("lines") int lines);
}
