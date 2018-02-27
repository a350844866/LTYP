package cn.vworld.controller;

import cn.vworld.bean.MovieInfo;
import cn.vworld.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
@Transactional
public class SingleController {
    @Autowired
    private MovieService movieService;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "hello,现在是"+new Date().toLocaleString();
    }


    //主页
    @RequestMapping("/index")
    public String index1() {

        return "redirect:/movie/showmovie";
    }
    //为了localhost:8090的直接跳转
    @RequestMapping("/")
    public String index() {
        return "redirect:/right";

    }
}
