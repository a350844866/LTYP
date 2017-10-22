package cn.vworld.controller.backcontroller;

import cn.vworld.bean.EchartDate;
import cn.vworld.bean.returnEchartDate;
import cn.vworld.tool.GetHtml;
import cn.vworld.tool.Uitil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/backend")
public class IndexController {

    @RequestMapping("/getEcherts")
    @ResponseBody
    public returnEchartDate lineData(HttpServletRequest request) throws Exception {
        System.out.println("我要返回数据了！！！！！！");
        String titleData;
        String subtextData;
        String Alltoxoffice;
        List<String> xAxisDate = new ArrayList<String>();
        List<String> seriesData1 = new ArrayList<String>();
        List<String> seriesData2 = new ArrayList<String>();

        List<EchartDate> echartDateList = GetHtml.ParseMovieData(request);

        for (int i = 0; i < echartDateList.size(); i++) {
            xAxisDate.add(echartDateList.get(i).getMovieName());
            seriesData1.add(Uitil.SlipString(echartDateList.get(i).getDayboxoffice()));
            seriesData2.add(Uitil.SlipString(echartDateList.get(i).getAllboxoffice()));
        }
        titleData = echartDateList.get(0).getMovieTile();
        subtextData = echartDateList.get(1).getMovieTile();
        Alltoxoffice = echartDateList.get(2).getMovieTile();

        returnEchartDate Eachartdata = new returnEchartDate(titleData, subtextData, Alltoxoffice, xAxisDate, seriesData1, seriesData2);

        return Eachartdata;

    }
}
