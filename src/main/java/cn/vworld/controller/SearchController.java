package cn.vworld.controller;

import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.User;
import cn.vworld.service.UserService;
import cn.vworld.service.backservice.BackendMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private BackendMovieService backendMovieService;

    @RequestMapping("/backend/search")
    public String search(Model model, String search, String key, String showpage) {
        if (search.equals("movie")) {

            int page = 1;

            /** 定义每一页的行数为10行 */
            int lines = 10;

            /**
             * 判断showpage是否为空
             * 最开始的搜索结果肯定为空
             */
            if (showpage != null) {
                page = Integer.parseInt(showpage);
            }

            int searchMovieNum = backendMovieService.findMovieByKey(key);

            System.out.println(searchMovieNum);

            int allPages = searchMovieNum % lines == 0 ? (searchMovieNum / lines) : (searchMovieNum / lines) + 1;
            List<MovieInfo> movieInfoList = backendMovieService.findMovieListBykey((page - 1) * lines, lines, key);

            System.out.println(movieInfoList.toString());

            model.addAttribute("movieList", movieInfoList);
            model.addAttribute("allpages", allPages);
            model.addAttribute("search_key", key);

            return "/backend/movieList";

        } else {

            int page = 1;

            int lines = 8;

            if (showpage != null) {
                page = Integer.parseInt(showpage);
            }

            int userNumByKey = userService.findUserNumBykey(key);

            int allpages = userNumByKey % lines == 0 ? (userNumByKey / lines) : (userNumByKey / lines) + 1;

            List<User> userList = userService.findUserByUsername((page - 1) * lines, lines, key);
            model.addAttribute("userList", userList);
            model.addAttribute("allpages", allpages);

            model.addAttribute("search_key", key);
            return "/backend/userList";
        }
    }
}
