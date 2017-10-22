package cn.vworld.tool;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {



        public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath + fileName+".jpg");
            out.write(file);
            out.flush();
            out.close();
        }

}
