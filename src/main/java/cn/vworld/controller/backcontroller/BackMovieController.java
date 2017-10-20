package cn.vworld.controller.backcontroller;

import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import cn.vworld.controller.BaseController;
import cn.vworld.service.backservice.BackendMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/backend")
public class BackMovieController extends BaseController{

    @Autowired
    private BackendMovieService backendMovieService;

    /**
     * 跳转到后台主页
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String  toBackendInd(Model model) {

        Integer movieNum = backendMovieService.findMovieNum();

        Integer movieTypeNum = backendMovieService.findMovieTypeNum();

        Integer userNum = backendMovieService.findUserNum();

        List<MovieInfo> movieInfoList = backendMovieService.findAllMovie();

        List<Type> movieTypeList = backendMovieService.findAllMovieType();

        List<User> userList = backendMovieService.findUserByCommentNum();

        model.addAttribute("movieNum", movieNum);
        model.addAttribute("movieTypeNum", movieTypeNum);
        model.addAttribute("userNum", userNum);

        model.addAttribute("movieInfoList", movieInfoList);
        model.addAttribute("movieTypeList", movieTypeList);
        model.addAttribute("userList", userList);


        return "/backend/index";
    }

    //电影分页要求： 默认10行数据
    //             获取当前的总页数
    //             获取当前电影的15行数据
    //             获取返回的当前页数


    @RequestMapping("/movieList")
    public String toMovieList(Model model, String showpage){

        int  page = 1;

        int lines = 10;
           if(showpage != null){
               page = Integer.parseInt(showpage);
           }


       int allmovies = backendMovieService.findMovieNum();

       int   allpages = allmovies % lines == 0 ? (allmovies / lines) : (allmovies / lines)+1;

       List<MovieInfo> movieInfoList = backendMovieService.findMovieList((page-1)*lines, lines);

       // List<MovieInfo> movieList = backendMovieService.findAllMovie();

        model.addAttribute("movieList", movieInfoList);
        model.addAttribute("allpages",allpages);

        return "/backend/movieList";
    }


    /**
     * 跳转到添加新电影列表
     * @return
     */
    @RequestMapping("/addMovie")
    public String toAddMovie(){

        return "/backend/addMovie";
    }

    /**
     * 保存新电影到数据库，并且跳转到电影列表页面
     * @param movieInfo
     * @return
     */
    @RequestMapping("/toMovieList")
    public String toMovieList(MovieInfo movieInfo){


        backendMovieService.saveMovie(movieInfo);

        return "redirect:/backend/movieList";
    }





}