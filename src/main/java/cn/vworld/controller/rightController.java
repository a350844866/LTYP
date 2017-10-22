package cn.vworld.controller;

import cn.vworld.bean.EchartDate;
import cn.vworld.tool.GetHtml;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class rightController {
    @RequestMapping("/right")
    public String RightData(Model model, HttpServletRequest request) throws Exception {
        List<String> LinksDate = new ArrayList<String>();
        List<EchartDate> echartDateList = GetHtml.ParseMovieData(request);
        for (int i = 0; i < 5; i++) {
            String str = echartDateList.get(i).getMovielink();
            int len = str.length();
            str = str.substring(4, len - 5);
            LinksDate.add(str);
        }
        model.addAttribute("LinksDate", LinksDate);
        return "index";
    }
}
