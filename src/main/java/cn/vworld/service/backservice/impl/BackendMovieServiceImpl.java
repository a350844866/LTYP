package cn.vworld.service.backservice.impl;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import cn.vworld.mapper.BackendMovieMapper;
import cn.vworld.mapper.MovieTypeMapper;
import cn.vworld.mapper.TypeMapper;
import cn.vworld.service.backservice.BackendMovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BackendMovieServiceImpl implements BackendMovieService {

    @Autowired
    private JedisPool jedisPool;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private BackendMovieMapper backendMovieMapper;

    @Autowired
    private MovieTypeMapper movieTypeMapper;

    @Override
    public Integer findMovieNum() {
        return backendMovieMapper.findMovieNum();
    }

    @Override
    public Integer findMovieTypeNum() {
        Jedis jedis = jedisPool.getResource();
        String allTypeNum = jedis.get("LTYP_ALLTYPE_NUM");
        try {
            if (!StringUtils.isEmpty(allTypeNum)) {
                Integer num = objectMapper.readValue(allTypeNum, int.class);
                return num;
            } else {
                Integer num = backendMovieMapper.findMovieTypeNum();
                jedis.set("LTYP_ALLTYPE_NUM", objectMapper.writeValueAsString(num));
                return num;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void saveMovie(MovieInfo movieInfo, String[] xqpath, int[] typeId) {
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
        for (int t : typeId) {
            movieTypeMapper.insert(movieId, t);
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
