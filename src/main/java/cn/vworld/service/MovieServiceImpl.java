package cn.vworld.service;

import cn.vworld.bean.MovieInfo;
import cn.vworld.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;



    @Override
    public Integer findMovieNum() {
        return movieMapper.findMovieNum();
    }

    @Override
    public ArrayList<MovieInfo> findthirdfourMovie(Integer page) {
        ArrayList<MovieInfo> third = movieMapper.findthirdfourMovie(page);
        return third;
    }

    @Override
    public ArrayList<MovieInfo> findsecondfourMovie(Integer page) {
        ArrayList<MovieInfo> second = movieMapper.findsecondfourMovie(page);
        return second;
    }

    @Override
    public ArrayList<MovieInfo> findfirstfourMovie(Integer page) {
        ArrayList<MovieInfo> first = movieMapper.findfirstfourMovie(page);
        return first;
    }
}
