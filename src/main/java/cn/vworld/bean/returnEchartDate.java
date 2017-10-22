package cn.vworld.bean;

import java.util.ArrayList;
import java.util.List;

public class returnEchartDate {
    public String titleData;
    public String subtextData;
    public String Alltoxoffice;
    public List<String> xAxisDate = new ArrayList<String>();
    public List<String> seriesData1 = new ArrayList<String>();
    public List<String> seriesData2 = new ArrayList<String>();

    public returnEchartDate(String titleData,
                            String subtextData,
                            String alltoxoffice,
                            List<String> xAxisDate,
                            List<String> seriesData1,
                            List<String> seriesData2) {
        this.titleData = titleData;
        this.subtextData = subtextData;
        Alltoxoffice = alltoxoffice;
        this.xAxisDate = xAxisDate;
        this.seriesData1 = seriesData1;
        this.seriesData2 = seriesData2;
    }
}
