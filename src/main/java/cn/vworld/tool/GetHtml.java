package cn.vworld.tool;

import cn.vworld.bean.EchartDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class GetHtml {

    public static void Get_Url(String url, HttpServletRequest request) {
        String filePath1 = request.getSession().getServletContext().getRealPath("html/");

        try {

            File dest = new File(filePath1 + "Echart.html");

            InputStream is;

            FileOutputStream fos = new FileOutputStream(dest);

            URL temp = new URL(url);

            URLConnection uc = temp.openConnection(); //jianli lianjie

            uc.addRequestProperty("User-Agent", "Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");

            is = temp.openStream();

            //为字节输入流加缓冲
            BufferedInputStream bis = new BufferedInputStream(is);
            //为字节输出流加缓冲
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int length;

            byte[] data = new byte[1020 * 10];
            while ((length = bis.read(data, 0, data.length)) != -1) {
                fos.write(data, 0, length);
            }
            bos.close();
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("openStream流错误，跳转get流");
            try {
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)")
                        .timeout(3000)
                        .get();
                File dest = new File(filePath1 + "Echart.html");
                if (!dest.exists())
                    dest.createNewFile();
                FileOutputStream out = new FileOutputStream(dest, false);
                out.write(doc.toString().getBytes("utf-8"));
                out.close();

            } catch (IOException E) {
                E.printStackTrace();
                System.out.println("get流错误，请检查网址是否正确");
            }
        }
        System.out.println("爬取成功！！```````");
    }

    //解析网页
    public static List<EchartDate> ParseMovieData(HttpServletRequest request) throws Exception {
        String url = "http://movie.mtime.com/boxoffice/#US/weekend";
        String filePath1 = request.getSession().getServletContext().getRealPath("html/");
        Get_Url(url, request);
        String[] movieName = new String[11];
        String[] boxofficeDay = new String[11];
        String[] Allboxoffice = new String[11];
        String[] Dayboxoffice = new String[11];
        String[] Movielink = new String[11];
        String[] MovieTitle = new String[11];
        List<EchartDate> echartDate = new ArrayList<>();//存储电影爬虫电影信息
        String DataPath = filePath1 + "Echart.html";
        //读取本地html的路径
        File file = new File(DataPath);
        Document doc = Jsoup.parse(file, "UTF-8");
        //标题数据
        Elements Titlelinks = doc.getElementsByClass("typetitle");
        //主标题
        Elements Title = Titlelinks.get(0).getElementsByTag("h4");
        //  System.out.println("主标题:"+Title.text().toString());
        MovieTitle[0] = Title.text().toString();
        //副标题
        Elements SubTitle = Titlelinks.select("p.updateday");
        MovieTitle[1] = SubTitle.text().toString();
        // System.out.println("副标题"+SubTitle.text().toString());
        //电影票房数据
        Elements movieLinks = doc.getElementsByClass("boxofficelist");
        Elements moiveList = movieLinks.select("div.movietopmod");
        int count = 0;
        //电影名称
        for (int i = 0; i < moiveList.size(); i++) {
            Element moiveNames = moiveList.get(i).getElementsByTag("h3").get(0);
            Elements a_moive = moiveList.get(i).getElementsByTag("h3");
            movieName[i] = moiveNames.text();
            Movielink[i] = a_moive.toString();
            // System.out.println("电影名称" + moiveNames.text());
            //  System.out.println("电影的路径" + a_moive);
        }
        //总票房和日票房
        Elements boxoffice = moiveList.select("p.totalnum");
        int i = 0;
        int k = 0;
        for (int j = 0; j < boxoffice.size(); j++) {
            if (j % 2 == 0) {
                Allboxoffice[i++] = boxoffice.get(j).text().toString();
            } else {
                Dayboxoffice[k++] = boxoffice.get(j).text().toString();
            }
        }


        Elements dayAllboxoffice = Titlelinks.select("div.showtype");
        //System.out.println("全国单日总票房：" +dayAllboxoffice.get(0).text().toString());
        MovieTitle[2] = dayAllboxoffice.get(0).text().toString();
        for (int h = 0; h < 10; h++) {
            EchartDate EDate = new EchartDate();
            EDate.setMovieName(movieName[h]);
            EDate.setAllboxoffice(Allboxoffice[h]);
            EDate.setMovielink(Movielink[h]);
            EDate.setMovieTile(MovieTitle[h]);
            EDate.setDayboxoffice(Dayboxoffice[h]);
            echartDate.add(EDate);
        }
        return echartDate;
    }
}