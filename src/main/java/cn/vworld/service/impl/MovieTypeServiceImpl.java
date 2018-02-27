package cn.vworld.service.impl;

import cn.vworld.mapper.MovieTypeMapper;
import cn.vworld.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiaxu
 * @version $Id: MovieTypeServiceImpl.java, v 0.1 2018/2/26 18:23 jiaxu Exp $$
 */
@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    @Autowired
    private MovieTypeMapper movieTypeMapper;

    /**
     * 通过电影id来查找类型id
     *
     * @param movieId
     * @return
     */
    @Override
    public List<String> selectTypeIdByMovieId(String movieId) {
        return movieTypeMapper.selectTypeIdByMovieId(movieId);
    }

    /**
     * 通过movieId来删除movieType表中的数据
     *
     * @param movieId
     */
    @Override
    public void deleteMovieTypeByMovieId(String movieId) {
        movieTypeMapper.deleteMovieTypeByMovieId(movieId);
    }

}
