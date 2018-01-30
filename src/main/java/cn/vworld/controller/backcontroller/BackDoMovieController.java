package cn.vworld.controller.backcontroller;

import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.service.MovieService;
import cn.vworld.service.backservice.BackDoMovieService;
import cn.vworld.service.backservice.BackendMovieService;
import cn.vworld.tool.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/backend")
public class BackDoMovieController {

    @Autowired
    private BackDoMovieService backDoMovieService;

    @Autowired
    private BackendMovieService backendMovieService;

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

        System.out.println(movieImage0.getImageUrl());
        System.out.println(movieImage1.getImageUrl());

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

        MovieImage movieImage0 = movieImageList.get(0);
        MovieImage movieImage1 = movieImageList.get(1);

        model.addAttribute("movieInfo", movieInfo);
        model.addAttribute("movieImage0", movieImage0);
        model.addAttribute("movieImage1", movieImage1);

        model.addAttribute("movieId", movieId);

        return "/backend/updateMovie";
    }

    /**
     * 修改电影之后的入库操作
     */
    @RequestMapping("update")
    public String UpdateMovietoDb(MovieInfo movieInfo, MovieImage movieImage, HttpServletRequest request) {

        backDoMovieService.deleteMovieInfoByMovieId(movieInfo.getMovieId());

        backDoMovieService.deleteMovieImageByMovieId(movieInfo.getMovieId());

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;

        String[] xqPath = new String[3];
        String contentType = null;
        String fileName = null;
        String filePath = request.getSession().getServletContext().getRealPath("/staticfile/images/");


        //服务器文件路径设置
        String ImgePath = "staticfile/images/";
        //海报路径
        String postPath = null;

        //详情页面
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
//            contentType = file.getContentType(); //获取文件类型
            fileName = UUID.randomUUID().toString();


            if (i == 0) {
                postPath = ImgePath + fileName + ".jpg";

                //设置海报的路径

                movieInfo.setPoster(postPath);

            } else {
                //详情页图片路径
                xqPath[i - 1] = ImgePath + fileName + ".jpg";
                System.out.println("*****************" + xqPath[i - 1]);

            }

            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName + ".jpg");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        backendMovieService.saveMovie(movieInfo, xqPath);


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
