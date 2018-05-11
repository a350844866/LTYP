package cn.vworld.utils;

import cn.vworld.bean.Rangking;
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
import java.util.UUID;




public class Get_Html{


     public static void Get_Url(String url,HttpServletRequest request)  {

         String filePath1 = request.getSession().getServletContext().getRealPath("html/");

         try {

            File dest = new File(filePath1+"msg.html");



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
             while ((length = bis.read(data,0, data.length)) !=-1){
                 fos.write(data, 0, length);
             }

             bos.close();
             fos.close();
             bis.close();
             is.close();
         }catch (IOException e){
             e.printStackTrace();
             System.out.println("openStream流错误，跳转get流");
             try {
                 Document doc = Jsoup.connect(url)
                         .userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)")
                         .timeout(3000)
                         .get();
                 File dest = new File(filePath1+"E://msg.html");
                 if(!dest.exists())
                     dest.createNewFile();
                 FileOutputStream out=new FileOutputStream(dest,false);
                 out.write(doc.toString().getBytes("utf-8"));
                 out.close();

             }catch (IOException  E){
                 E.printStackTrace();
                 System.out.println("get流错误，请检查网址是否正确");
             }
         }
     }


     //解析网页
  public static  List<Rangking> ParseHtml(HttpServletRequest request,String Urlpath) throws Exception {

     //xiazaiwangye


     Get_Url(Urlpath,request);

      String filePath1 = request.getSession().getServletContext().getRealPath("html/");

      String  filePath = filePath1 + "msg.html";



      int count = 0;
      int sum = 0;
      String[] images =new String[11];//图片列表
      String[] movieName = new String[11];//图片列表
      String[] actors = new String[11]; //演员列表
      String[] evaluation = new String[11];//评价列表
      String[] evaluationscore = new String[11];//评分列表
      List<Rangking> rangkingList = new ArrayList<>();//排行榜对象


      //读取本地html的路径
      File file = new File(filePath);
      Document doc = Jsoup.parse(file, "UTF-8");
      Elements links = doc.getElementsByClass("indent");
      Element link = links.get(0);
      sum = links.size();

//      System.out.println("**************"+links.size());

     //图片列表
      Elements All_aa = link.getElementsByTag("a");
      Elements Images = All_aa.select("img[src$=.jpg]");// 图片路径
      for (Element img : Images){
          images[count] = img.toString();
          System.out.println( images[count]);
          count ++;

      }

    //演员列表
      count=0;
      Elements doctors_msg = link.select("p.pl");

      for (Element doctors : doctors_msg){
          actors[count] =doctors.text().toString();
          count ++;
      }


      //评分列表
      count=0;
      Elements score_p = link.select("span.rating_nums");
      for (Element score : score_p){
          evaluationscore[count] = score.text().toString();
          count++;
      }
      //评价列表
      count=0;
      Elements person_score = link.select("span.pl");
      for (Element person : person_score){
          evaluation[count] = person.text().toString();
          count++;
      }

      //查询影名称
      Elements movie_name = link.select("div.pl2");
      Element link_a = movie_name.get(0);
      count=0;
    for (Element movie_a : movie_name ){
        Elements span_text = movie_a.getElementsByTag("a");
        for (Element span : span_text){
            movieName[count] = span.toString();
            count++;
        }
    }
//      String[] images =new String[11];//图片列表
//      String[] movieName = new String[11];//图片列表
//      String[] actors = new String[11]; //演员列表
//      String[] evaluation = new String[11];//评价列表
//      String[] evaluationscore = new String[11];//评分列表

   for(int j = 0; j < 10; j++){
       Rangking rangking = new Rangking();
       rangking.setRangkingID(UUID.randomUUID().toString());
       rangking.setRangkingImg(images[j]);
       rangking.setRangkingName(movieName[j]);
       rangking.setRangkingDoc(actors[j]);
       rangking.setRangkingScore(evaluationscore[j]);
       rangking.setRangkingRemark(evaluation[j]);
       rangkingList.add(rangking);
   }

   return rangkingList;
  }

}
