package cn.vworld.service.backservice.impl;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import cn.vworld.mapper.BackendMovieMapper;
import cn.vworld.service.backservice.BackendMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
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
    public void saveMovie(MovieInfo movieInfo, String[] xqpath) {
        String movieId = UUID.randomUUID().toString();

        movieInfo.setMovieId(movieId);

        movieInfo.setCreateTime(new Date());

        movieInfo.setUpdateTime(movieInfo.getCreateTime());
        if (movieInfo.getAvgscore() == null) {
            movieInfo.setAvgscore(new Double(0));
        }
        backendMovieMapper.saveMovie(movieInfo);

        if (xqpath == null) {
            return;
        }

        MovieImage movieImage = null;

        for (int i = 0; i < xqpath.length; i++) {
            String imageId = UUID.randomUUID().toString();

            movieImage = new MovieImage();
            movieImage.setMovieId(movieId);
            movieImage.setImageId(imageId);
            movieImage.setImageUrl(xqpath[i]);

            backendMovieMapper.saveMoviexqPath(movieImage);


            if (movieImage.getImageUrl() == null) {
                backendMovieMapper.deleteNullPosterUrl(movieImage.getImageId());
            }


        }


    }

    @Override
    public int findMovieByKey(String key) {
        return backendMovieMapper.findMovieByKey(key);
    }

    @Override
    public List<MovieInfo> findMovieListBykey(int showpage, int lines, String key) {
        return backendMovieMapper.findMovieListBykey(showpage, lines, key);
    }

    @Override
    public List<MovieInfo> findMovieListOrderByAvgScore(int showpage, int lines) {
        return backendMovieMapper.findMovieListOrderByAvgScore(showpage, lines);
    }
}
