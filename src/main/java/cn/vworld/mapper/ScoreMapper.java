package cn.vworld.mapper;

import cn.vworld.bean.Score;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    /**
     * 是否存在评分
     *
     * @param userId
     * @param movieId
     * @return
     */
    Score isScoreExist(@Param("userId") String userId, @Param("movieId") String movieId);

    /**
     * 插入评分
     * @param score
     */
    void insertScore(Score score);

    /**
     * 查找电影的平均评分
     * @param movieId
     * @return
     */
    Double getAvgScore(String movieId);
}
