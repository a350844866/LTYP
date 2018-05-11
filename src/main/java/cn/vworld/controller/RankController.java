//package cn.vworld.controller;
//
//import cn.vworld.bean.Rangking;
//import cn.vworld.utils.Get_Html;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/rank")
//@Transactional
//public class RankController {
//    @Autowired
//    private RankController rankService;
//    private String Urlpath = "https://movie.douban.com/chart";
//
//
//    /**
//     * 通过Get_Html类往指定Urlpath获取排行榜电影数据
//     * @param request   页面请求
//     * @param model 向页面添加属性
//     * @return
//     */
//    @RequestMapping("/list")  //排行首页
//    public String toRankList(HttpServletRequest request,Model model, String page) throws Exception {
//        int beginitem = 0;
//        int enditem = 0;
//        List<Rangking> b_rangkingList = new ArrayList<>();  //第一页
//        List<Rangking> e_rangkingList = new ArrayList<>();  //第二页
//
//
//
//            List<Rangking> rankList = Get_Html.ParseHtml(request,Urlpath);
//            System.out.println(rankList.size());
//            int len = rankList.size();
//            for(Rangking r:rankList){
//                r.setStarScore((int)(Double.parseDouble(r.getRangkingScore()))*10/20*10+5);
//            }
//
//            for(int i=0;i<5;i++){
//                b_rangkingList.add(rankList.get(i));
//
//            }
//            System.out.println(b_rangkingList.toString());
//            for (int i=5;i<10;i++){
//                e_rangkingList.add(rankList.get(i));
//            }
//            System.out.println(page);
//            System.out.println(e_rangkingList.toString());
//            if(page == null || page.equals("1") ){
//
//                model.addAttribute("rankList", b_rangkingList);
//                return "movie/rank";
//            }else{
//
//                model.addAttribute("rankList",e_rangkingList);
//                return "movie/rank";
//            }
//
//    }
//
//    @RequestMapping("/update")
//    public String rank(){
//        return "movie/rank";
//    }
//}
package cn.vworld.controller;

import cn.vworld.bean.Rangking;
import cn.vworld.utils.Get_Html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rank")
@Transactional
public class RankController {
    @Autowired
    private RankController rankService;
    private String Urlpath = "https://movie.douban.com/chart";

    /**
     * 通过Get_Html类往指定Urlpath获取排行榜电影数据
     * @param request   页面请求
     * @param model 向页面添加属性
     * @return
     */
    @RequestMapping("/list")  //排行首页
    public String toRankList(HttpServletRequest request, Model model, String page) throws Exception {
        int beginitem = 0;
        int enditem = 0;
        List<Rangking> b_rangkingList = new ArrayList<>();  //第一页
        List<Rangking> e_rangkingList = new ArrayList<>();  //第二页
        List<Rangking> rankList = Get_Html.ParseHtml(request, Urlpath);
        System.out.println(rankList.size() + "````````````````````````");
        //System.out.println(rankList);
        int len = rankList.size();
        for (Rangking r : rankList) {
            if (r.getRangkingScore() != null) {
                r.setStarScore((int)(Double.parseDouble(r.getRangkingScore()))*10/20*10+5);
            } else {
                r.setStarScore(35);
                r.setRangkingRemark("(562568人评价)");
            }
            // System.out.println((int)(Double.parseDouble(r.getRangkingScore()))*10/20*10+5);
        }
        System.out.println("***********************");
        for (int i = 0; i < 5; i++) {
            b_rangkingList.add(rankList.get(i));

        }
        System.out.println(b_rangkingList.toString());
        for (int i = 5; i < 10; i++) {
            e_rangkingList.add(rankList.get(i));
        }
        System.out.println(page);
        System.out.println(e_rangkingList.toString());
        if (page == null || page.equals("1")) {

            model.addAttribute("rankList", b_rangkingList);
            return "movie/rank";
        } else {

            model.addAttribute("rankList", e_rangkingList);
            return "movie/rank";
        }

    }

    @RequestMapping("/update")
    public String toupdate(){
        return "movie/rank";
    }
}
