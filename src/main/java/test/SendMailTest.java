package test;

import cn.vworld.utils.MailUtils;

public class SendMailTest {
    public static void main(String[] args) throws Exception {
        System.out.println("测试1000");
        MailUtils.sendMail("929710370@qq.com", "www.baidu.com");
    }
}
