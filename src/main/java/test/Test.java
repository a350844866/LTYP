package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add(null);
        switch (list.get(0)) {
            case "1":
                break;
            default:
                break;
        }

    }
}
