package cn.vworld.tool;

public class Uitil {
    public static String SlipString(String data) {
        char s = data.charAt(data.length() - 1);
        if (s == '万') {
            data = data.substring(0, data.length() - 1);
            double douData = Double.parseDouble(data);
            douData = douData / 10000;
            return douData + "";
        } else {
            data = data.substring(0, data.length() - 1);
        }
        return data;
    }
}
