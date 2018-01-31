package cn.vworld.controller.backcontroller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.vworld.bean.MovieInfo;
import cn.vworld.bean.Type;
import cn.vworld.bean.TypeAndCount;
import cn.vworld.bean.User;
import cn.vworld.controller.BaseController;
import cn.vworld.service.CommentService;
import cn.vworld.service.MovieService;
import cn.vworld.service.TypeService;
import cn.vworld.service.UserService;
import cn.vworld.service.backservice.BackendMovieService;

import cn.vworld.tool.FileUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

@Controller
@RequestMapping("/backend")
public class BackMovieController extends BaseController{

    @Autowired
    private BackendMovieService backendMovieService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TypeService typeService;

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

        int commentCount = commentService.getCommentCount();

        int recentCommentCount = commentService.getRecentCommentCount();

        int recentRegistUser = userService.findRecentRegisterUser();


        model.addAttribute("movieNum", movieNum);
        model.addAttribute("movieTypeNum", movieTypeNum);
        model.addAttribute("userNum", userNum);
        model.addAttribute("commentCount", commentCount);
        model.addAttribute("recentCommentCount", recentCommentCount);
        model.addAttribute("movieInfoList", movieInfoList);
        model.addAttribute("movieTypeList", movieTypeList);
        model.addAttribute("userList", userList);
        model.addAttribute("recentRegisterUser", recentRegistUser);

        List<TypeAndCount> typeAndCount = typeService.getTypeNameAndCountMap();
        Map<String, Integer> map = new HashMap<>();
        typeAndCount.forEach(n -> {
            map.put(n.getTypeName(), n.getCount());
        });
        model.addAttribute("map", map);
        return "/backend/index";
    }

    //电影分页要求： 默认10行数据
    //             获取当前的总页数
    //             获取当前电影的10行数据
    //             获取返回的当前页数


    @RequestMapping("/movieList")
    public String toMovieList(Model model, String showpage, String key) {

        int  page = 1;

        int lines = 10;

        if (showpage != null) {
            page = Integer.parseInt(showpage);
        }


        int allmovies = backendMovieService.findMovieNum();

        int   allpages = allmovies % lines == 0 ? (allmovies / lines) : (allmovies / lines)+1;
        List<MovieInfo> movieInfoList = null;
        if (StringUtils.isEmpty(key)) {
            movieInfoList = backendMovieService.findMovieList((page - 1) * lines, lines);
        } else {
            movieInfoList = backendMovieService.findMovieListBykey((page - 1) * lines, lines, key);
        }


        // List<MovieInfo> movieList = backendMovieService.findAllMovie();

        model.addAttribute("movieList", movieInfoList);
        model.addAttribute("allpages", allpages);

        return "/backend/movieList";
    }

    @RequestMapping("/orderedByAvgScoreMovieList")
    public String orderedByAvgScoreMovieList(Model model) {
        int page = 1;

        int lines = 10;


        int allmovies = backendMovieService.findMovieNum();

        int allpages = allmovies % lines == 0 ? (allmovies / lines) : (allmovies / lines) + 1;
        List<MovieInfo> movieInfoList = backendMovieService.findMovieListOrderByAvgScore((page - 1) * lines, lines);
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
    public String toMovieList(MovieInfo movieInfo, HttpServletRequest request) {

        if ("".equals(movieInfo.getMovieName()) && "".equals(movieInfo.getShowTime())
                && "".equals(movieInfo.getDescription()) && "".equals(movieInfo.getDirector())
                && "".equals(movieInfo.getActor()) && "".equals(movieInfo.getPoster())
                && "".equals(movieInfo.getPlaytime()) && "".equals(movieInfo.getCountry())) {

            return "redirect:/backend/addMovie";
        }

        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;

        String[] xqPath =new String[3];
        String contentType = null;
        String fileName = null;
        String filePath = request.getSession().getServletContext().getRealPath("/staticfile/images/");


        //服务器文件路径设置
           String ImgePath = "staticfile/images/";
        //海报路径
           String postPath = null;

       //详情页面
        for(int i = 0; i < files.size(); i++){
            file  = files.get(i);
//            contentType = file.getContentType(); //获取文件类型
            fileName =  UUID.randomUUID().toString();




          if(i == 0){
                postPath = ImgePath + fileName + ".jpg";

                //设置海报的路径

                movieInfo.setPoster(postPath);

            }else{
                //详情页图片路径
                xqPath[i-1] = ImgePath+fileName+".jpg";
                System.out.println("*****************"+xqPath[i-1]);

            }

            try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName + ".jpg");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        //backendMovieService.saveMovieING(xqPath);//插入详情页面


        backendMovieService.saveMovie(movieInfo, xqPath);

        return "redirect:/backend/movieList";
    }





}