package cn.vworld.mapper;

import cn.vworld.bean.Score;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    Score isScoreExist(@Param("userId") String userId, @Param("movieId") String movieId);

    void insertScore(Score score);

    Double getAvgScore(String movieId);
}
