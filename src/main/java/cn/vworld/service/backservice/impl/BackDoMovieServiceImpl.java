package cn.vworld.service.backservice.impl;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.mapper.BackDoMovieMapper;
import cn.vworld.mapper.TypeMapper;
import cn.vworld.service.backservice.BackDoMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BackDoMovieServiceImpl implements BackDoMovieService {

    @Autowired
    private BackDoMovieMapper backDoMovieMapper;


    @Override
    public MovieInfo findMovieInfoByMovieId(String movieId) {

        return backDoMovieMapper.findMovieInfoByMovieId(movieId);
    }

    @Override
    public List<MovieImage> findMovieImageByMovieId(String movieId) {
        return backDoMovieMapper.findMovieImageByMovieId(movieId);
    }

    /**
     * 修改入库操作前先把对应movieId的movieInfo删除
     *
     * @param movieId
     */
    @Override
    public void deleteMovieInfoByMovieId(String movieId) {

        backDoMovieMapper.deleteMovieInfoByMovieId(movieId);
    }

    /**
     * 修改前先根据movieId删除movieImage实例
     *
     * @param movieId
     */
    @Override
    public void deleteMovieImageByMovieId(String movieId) {
        backDoMovieMapper.deleteMovieImageByMovieId(movieId);
    }

    @Override
    public void deleteMovieInfoByMovieIds(String[] movieIds) {
        backDoMovieMapper.deleteMovieInfoByMovieIds(movieIds);
    }

    @Override
    public void deleteMovieImageByMovieIds(String[] movieIds) {
        backDoMovieMapper.deleteMovieImageByMovieIds(movieIds);
    }
}
