package cn.vworld.service.backservice;

import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import cn.vworld.mapper.BackendMovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BackendMovieServiceImpl implements BackendMovieService {

    @Autowired
    private BackendMovieMapper backendMovieMapper;

    @Override
    public Integer findMovieNum() {
        return backendMovieMapper.findMovieNum();
    }

    @Override
    public Integer findMovieTypeNum() {
        return backendMovieMapper.findMovieTypeNum();
    }

    @Override
    public Integer findUserNum() {
        return backendMovieMapper.findUserNum();
    }

    @Override
    public List<MovieInfo> findAllMovie() {
        return backendMovieMapper.findAllMovie();
    }

    @Override
    public List<Type> findAllMovieType() {
        return backendMovieMapper.finAllMovieType();
    }

    @Override
    public List<User> findUserByCommentNum() {
        return backendMovieMapper.findUserByCommentNum();
    }

    @Override
    public List<MovieInfo> findMovieList(int showpage, int lines) {
        return backendMovieMapper.findMovieList(showpage, lines);
    }

    @Override
    public void saveMovie(MovieInfo movieInfo) {

        String movieId = UUID.randomUUID().toString();

        movieInfo.setMovieId(movieId);

        movieInfo.setCreateTime(new Date());

        movieInfo.setUpdateTime(movieInfo.getCreateTime());

        backendMovieMapper.saveMovie(movieInfo);
    }


}
