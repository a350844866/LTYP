package cn.vworld.controller.backcontroller;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.service.MovieService;
import cn.vworld.service.MovieTypeService;
import cn.vworld.service.TypeService;
import cn.vworld.service.backservice.BackDoMovieService;
import cn.vworld.service.backservice.BackendMovieService;
import cn.vworld.tool.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/backend")
@Transactional
public class BackDoMovieController {

    @Autowired
    private BackDoMovieService backDoMovieService;

    @Autowired
    private BackendMovieService backendMovieService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieTypeService movieTypeService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private JedisPool jedisPool;




    /**
     * 根据电影id查询电影详情
     *
     * @param model
     * @return
     */
    @RequestMapping("/toview")
    public String toView(String movieId, Model model) {

        if (movieId == null) {
            return "redirect:/backend/movieList";
        }

        /** 查询电影详情，但是里面只有一张海报图片 */
        MovieInfo movieInfo = backDoMovieService.findMovieInfoByMovieId(movieId);

        /** 根据movieId查询另外两张详情图片 */
        List<MovieImage> movieImageList = backDoMovieService.findMovieImageByMovieId(movieId);

        MovieImage movieImage0 = movieImageList.get(0);
        MovieImage movieImage1 = movieImageList.get(1);

        List<String> idList = movieTypeService.selectTypeIdByMovieId(movieId);
        StringBuffer typeName = new StringBuffer();
        idList.forEach(id -> typeName.append(typeService.selectTypeNameByTypeId(id) + ","));
        String typeNames = typeName.substring(0, typeName.length() - 1);

        System.out.println(movieImage0.getImageUrl());
        System.out.println(movieImage1.getImageUrl());

        model.addAttribute("typeNames", typeNames);
        model.addAttribute("movieInfo", movieInfo);
        model.addAttribute("movieImage0", movieImage0);
        model.addAttribute("movieImage1", movieImage1);

        return "/backend/movieInfo";
    }

    /**
     * 修改电影,跳转页面
     *
     * @return
     */
    @RequestMapping("/toupdate")
    public String toUpdate(String movieId, Model model) {


        if (movieId == null) {
            return "redirect:/backend/movieList";
        }

        /** 查询电影详情，但是里面只有一张海报图片 */
        MovieInfo movieInfo = backDoMovieService.findMovieInfoByMovieId(movieId);

        /** 根据movieId查询另外两张详情图片 */
        List<MovieImage> movieImageList = backDoMovieService.findMovieImageByMovieId(movieId);
        List<Type> typeList = typeService.getAllType();
        if (movieImageList.size() == 2) {
            MovieImage movieImage0 = movieImageList.get(0);
            MovieImage movieImage1 = movieImageList.get(1);
            model.addAttribute("movieImage0", movieImage0);
            model.addAttribute("movieImage1", movieImage1);
        }
        List<String> idList = movieTypeService.selectTypeIdByMovieId(movieId);
//        StringBuffer typeName = new StringBuffer();
//        StringBuffer ids = new StringBuffer();
//        idList.forEach(id-> typeName.append(typeService.selectTypeNameByTypeId(id)+","));
//        idList.forEach(id-> ids.append(id+","));
//        String typeids = ids.substring(0, ids.length() - 1);
        model.addAttribute("movieInfo", movieInfo);
        model.addAttribute("typeList", typeList);
        model.addAttribute("movieId", movieId);
        model.addAttribute("idList", idList);
        return "/backend/updateMovie";
    }

    /**
     * 修改电影之后的入库操作
     */
    @RequestMapping("/update")
    public String UpdateMovieToDB(MovieInfo movieInfo, HttpServletRequest request, int[] typeId) {



        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;

        String[] xqPath = new String[3];
        String contentType = null;
        String fileName = null;
        String filePath = request.getSession().getServletContext().getRealPath("/staticfile/images/");
        //删除原来的图片
        //先删除原来的海报
        String[] strs = movieInfo.getPoster().split("/");
        File oldPosterFile = new File(filePath + strs[strs.length - 1]);
        if (oldPosterFile.exists()) {
            oldPosterFile.delete();
        }
        //删除原来的两张详情页的图片
        List<MovieImage> oldImages = movieService.findMovieImageByMovieInfoId(movieInfo.getMovieId());
        oldImages.forEach(n -> {
            String[] urls = n.getImageUrl().split("/");
            File oldImage = new File(filePath + urls[urls.length - 1]);
            if (oldImage.exists()) {
                oldImage.delete();
            }
        });


        backDoMovieService.deleteMovieImageByMovieId(movieInfo.getMovieId());
        backDoMovieService.deleteMovieInfoByMovieId(movieInfo.getMovieId());
//        List<String> movieTypeIdList = movieTypeService.selectTypeIdByMovieId(movieInfo.getMovieId());
        movieTypeService.deleteMovieTypeByMovieId(movieInfo.getMovieId());
        //服务器文件路径设置
        String ImagePath = "staticfile/images/";
        //海报路径
        String postPath = null;

        //详情页面
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
//            contentType = file.getContentType(); //获取文件类型
            fileName = UUID.randomUUID().toString();


            if (i == 0) {
                postPath = ImagePath + fileName + ".jpg";

                //设置海报的路径

                movieInfo.setPoster(postPath);

            } else {
                //详情页图片路径
                xqPath[i - 1] = ImagePath + fileName + ".jpg";
                System.out.println("*****************" + xqPath[i - 1]);

            }

            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName + ".jpg");
            } catch (Exception e) {
            }
        }


        backendMovieService.saveMovie(movieInfo, xqPath, typeId);


        return "redirect:/backend/movieList";
    }


    /**
     * 根据movieId删除
     */
    @RequestMapping("/todelete")
    public String toDelete(@RequestParam("movieId") String[] movieIds) {

        if (movieIds.length == 0) {
            return "redirect:/backend/movieList";
        }

        backDoMovieService.deleteMovieInfoByMovieIds(movieIds);
        backDoMovieService.deleteMovieImageByMovieIds(movieIds);

        return "redirect:/backend/movieList";
    }
}
