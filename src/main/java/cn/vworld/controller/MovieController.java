package cn.vworld.controller;

import cn.vworld.bean.Comment;
import cn.vworld.bean.MovieImage;
import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.User;
import cn.vworld.service.MovieService;
import cn.vworld.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/movie")
@Transactional
public class MovieController {
    private Integer page = 1; //当前页数
    private Integer pages = 0;//总共有多少页
    private Integer pageMovie = 12;//每页显示的电影数
    private Integer movieNum = 0;//书籍的数量
    private Integer updateNum = 3;//右侧最近更新电影的数量
    private Integer resultPageMovie = 5;//在结果页每页显示的电影数
    public static HashMap<User, List<String>> map = new HashMap<User, List<String>>();

    @Autowired
    private MovieService movieService;

    @Autowired
    private TypeService typeService;
    /**
     * 展现首页 默认页码为1
     *
     * @param model
     * @param page  当前的页面
     * @return
     */
    @RequestMapping("/showmovie")
    public String showMovie(Model model, Integer page, HttpSession session) {
        movieNum = movieService.findMovieNum();
        pages = movieNum % pageMovie == 0 ? (movieNum / pageMovie) : (movieNum / pageMovie) + 1;
        model.addAttribute("pages", pages);
        page = 1;
        ArrayList<MovieInfo> movieList = movieService.findfirstfourMovie((page - 1) * pageMovie, 4);
        model.addAttribute("movieList", movieList);
        ArrayList<MovieInfo> movieList2 = movieService.findsecondfourMovie((page - 1) * pageMovie + 4, 4);
        model.addAttribute("movieList2", movieList2);
        ArrayList<MovieInfo> movieList3 = movieService.findthirdfourMovie((page - 1) * pageMovie + 8, 4);
        model.addAttribute("movieList3", movieList3);
        //右边的最近更新电影

        model.addAttribute("allType", typeService.getAllType());
        List<MovieInfo> newUpdate = movieService.findNewUpdateMovie(updateNum);
        session.setAttribute("newUpdate", newUpdate);
        return "index";
    }

    /**
     * 根据页码来翻页
     *
     * @param model
     * @param page  当前页面
     * @return
     */
    @RequestMapping("/findeAllPage")
    public String findAllBook(Model model, Integer page) {
        movieNum = movieService.findMovieNum();
        pages = movieNum % pageMovie == 0 ? (movieNum / pageMovie) : (movieNum / pageMovie) + 1;
        model.addAttribute("pages", pages);

        ArrayList<MovieInfo> movieList = movieService.findfirstfourMovie((page - 1) * pageMovie, 4);
        model.addAttribute("movieList", movieList);
        ArrayList<MovieInfo> movieList2 = movieService.findsecondfourMovie((page - 1) * pageMovie + 4, 4);
        model.addAttribute("movieList2", movieList2);
        ArrayList<MovieInfo> movieList3 = movieService.findthirdfourMovie((page - 1) * pageMovie + 8, 4);
        model.addAttribute("movieList3", movieList3);

        return "index";
    }

    @RequestMapping("/single")
    public String toSingle(String movieId, Model model) {
        MovieInfo movieInfo = movieService.findMovieInfoByMovieInfoId(movieId);
        model.addAttribute("movieInfo", movieInfo);
        List<MovieImage> imageList = movieService.findMovieImageByMovieInfoId(movieId);
        if (imageList != null) {
            if (System.currentTimeMillis() % 2 == 1) {
                model.addAttribute("movieimg", imageList.get(0));
            } else {
                model.addAttribute("movieimg", imageList.get(1));
            }
        }
        List<Comment> commentList = movieService.findCommentsByMovie(movieId);

        model.addAttribute("commentList", commentList);
        return "/movie/single";
    }

    @RequestMapping("/commitComment")
    public String commitComment(Integer movieId, String commDetail, HttpSession session) {
        User user_login = (User) session.getAttribute("user_login");
        if (user_login == null) {
            return "redirect:/login/signin";
        }
        Comment comment = new Comment();
        comment.setCommDetail(commDetail);
        comment.setMovieId(String.valueOf(movieId));
        comment.setUser(user_login);
        movieService.insertComment(comment);

        return "redirect:/movie/single?movieId=" + movieId;
    }

    @RequestMapping("/search")
    public String search(String search, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user_login");
        List<String> list = map.get(user);
        if (list == null) {
            list = new ArrayList<>();
        }
        Boolean flag = true;
        for (String s : list) {
            if (s.equals(search) || s.equals("")) {
                flag = false;
            }
        }
        if (flag) {
            list.add(0, search);
        }
        if (list.size() > 9) {
            list.remove(9);
        }
        map.put(user, list);
        session.setAttribute("map", map);

        Integer page_ = page;
        List<MovieInfo> movieInfoList = movieService.limitMovieListBySearch(search, (page_ - 1) * resultPageMovie, resultPageMovie);
        Integer count = movieService.findMovieNumBySearch(search);
        pages = count % resultPageMovie == 0 ? (count / resultPageMovie) : (count / resultPageMovie) + 1;
        model.addAttribute("movieInfoList", movieInfoList);
        model.addAttribute("pages", pages);
        model.addAttribute("search", search);
        return "/movie/result";
    }

    @RequestMapping("/typeSearch")
    public String typeSearch(String typeId, Model model, String page) {
        Integer page_ = 0;
        page_ = page == null ? this.page : Integer.valueOf(Integer.parseInt(page));
        List<MovieInfo> movieInfoList = movieService.limitTypeSearch(typeId, (page_ - 1) * resultPageMovie, resultPageMovie);
        Integer count = movieService.typeSearchCount(typeId);
        pages = count % resultPageMovie == 0 ? (count / resultPageMovie) : (count / resultPageMovie) + 1;
        model.addAttribute("typeId", typeId);
        model.addAttribute("typepages", pages);
        model.addAttribute("movieInfoList", movieInfoList);
        return "/movie/result";
    }

    @RequestMapping("/findeResultPage")
    public String findeResultPage(String search, String page, Model model) {
        Integer page_ = Integer.parseInt(page);
        List<MovieInfo> movieInfoList = movieService.limitMovieListBySearch(search, (page_ - 1) * resultPageMovie, resultPageMovie);
        model.addAttribute("movieInfoList", movieInfoList);
        model.addAttribute("pages", pages);
        model.addAttribute("search", search);
        return "/movie/result";
    }

    @RequestMapping("insertScore")
    public String insertScore(String userId, String movieId, String score, Model model) {
        Boolean isScoreExist = movieService.isScoreExist(userId, movieId);
        if (userId == "") {
            return "redirect:/login/signin";
        }
        if (!isScoreExist) {
            movieService.insertScore(userId, movieId, score);
            Double avgScore = movieService.getAvgScore(movieId);
            movieService.updateScore(movieId, avgScore);
        }

        return "redirect:/movie/single?movieId=" + movieId;
    }
}
