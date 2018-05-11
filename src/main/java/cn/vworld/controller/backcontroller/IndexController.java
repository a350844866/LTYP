package cn.vworld.controller.backcontroller;

import cn.vworld.bean.EchartDate;

import cn.vworld.bean.returnEchartDate;
import cn.vworld.utils.EcharUtils;
import cn.vworld.utils.GetHtml;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/backend")
@Transactional
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
            seriesData1.add(EcharUtils.SplitString(echartDateList.get(i).getDayboxoffice()));
            seriesData2.add(EcharUtils.SplitString(echartDateList.get(i).getAllboxoffice()));
        }
        titleData = echartDateList.get(0).getMovieTile();
        subtextData = echartDateList.get(1).getMovieTile();
        Alltoxoffice = echartDateList.get(2).getMovieTile();

        returnEchartDate echartDate = new returnEchartDate(titleData, subtextData, Alltoxoffice, xAxisDate, seriesData1, seriesData2);

        return echartDate;

    }
}
