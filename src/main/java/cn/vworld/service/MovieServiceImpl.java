package cn.vworld.service;

import cn.vworld.bean.Comment;
import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Score;
import cn.vworld.mapper.CommentMapper;
import cn.vworld.mapper.MovieImageMapper;
import cn.vworld.mapper.MovieMapper;
import cn.vworld.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieImageMapper movieImageMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public void updateScore(String movieId, Double avgScore) {
        movieMapper.updateScore(movieId, avgScore);
    }

    @Override
    public Double getAvgScore(String movieId) {
        return scoreMapper.getAvgScore(movieId);
    }

    @Override
    public void insertScore(String userId, String movieId, String score) {
        Score s = new Score();
        s.setMovieId(movieId);
        s.setScore(score);
        s.setUserId(userId);
        s.setCreateTime(new Date());
        s.setUpdateTime(s.getCreateTime());
        scoreMapper.insertScore(s);
    }

    @Override
    public Boolean isScoreExist(String userId, String movieId) {
        return scoreMapper.isScoreExist(userId, movieId) == null ? false : true;
    }

    @Override
    public List<MovieInfo> limitTypeSearch(String typeId, int page, Integer resultPageMovie) {
        return movieMapper.limitTypeSearch(typeId, page, resultPageMovie);
    }

    @Override
    public Integer typeSearchCount(String typeId) {
        return movieMapper.typeSearchCount(typeId);
    }

    @Override
    public List<MovieInfo> limitMovieListBySearch(String search, Integer page, Integer resultPageMovie) {
        return movieMapper.limitMovieListBySearch(search, page, resultPageMovie);
    }

    @Override
    public Integer findMovieNumBySearch(String search) {
        return movieMapper.findMovieNumBySearch(search);
    }

    @Override
    public List<MovieInfo> typeSearch(String typeId) {
        return movieMapper.typeSearch(typeId);
    }

    @Override
    public List<MovieInfo> findNewUpdateMovie(Integer number) {
        return movieMapper.findNewUpdateMovie(number);
    }

    @Override
    public List<MovieInfo> findMovieListBySearch(String search) {
        return movieMapper.findMovieListBySearch(search);
    }

    @Override
    public void insertComment(Comment comment) {
        comment.setCommId(UUID.randomUUID().toString());
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        commentMapper.insertComment(comment);
    }

    @Override
    public List<Comment> findCommentsByMovie(String movieInfoId) {
        return commentMapper.findCommentsByMovie(movieInfoId);
    }

    @Override
    public List<MovieImage> findMovieImageByMovieInfoId(String movieInfoId) {
        return movieImageMapper.findMovieImageByMovieInfoId(movieInfoId);
    }

    @Override
    public MovieInfo findMovieInfoByMovieInfoId(String movieInfoId) {
        return movieMapper.findMovieInfoByMovieInfoId(movieInfoId);
    }

    @Override
    public Integer findMovieNum() {
        return movieMapper.findMovieNum();
    }

    @Override
    public ArrayList<MovieInfo> findthirdfourMovie(Integer page, Integer rowNum) {
        ArrayList<MovieInfo> third = movieMapper.findthirdfourMovie(page, rowNum);
        return third;
    }

    @Override
    public ArrayList<MovieInfo> findsecondfourMovie(Integer page, Integer rowNum) {
        ArrayList<MovieInfo> second = movieMapper.findsecondfourMovie(page, rowNum);
        return second;
    }

    @Override
    public ArrayList<MovieInfo> findfirstfourMovie(Integer page, Integer rowNum) {
        ArrayList<MovieInfo> first = movieMapper.findfirstfourMovie(page, rowNum);
        return first;
    }
}
