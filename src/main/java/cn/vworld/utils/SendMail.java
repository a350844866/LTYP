package cn.vworld.utils;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendMail {
    /**
     * 邮件发送类
     * @param to 代表给谁发邮件
     * @param validateUrl 代表要发送的超链接
     * @throws Exception
     */
    public static void sendMail(String to, String validateUrl) throws Exception {
        // 1.创建连接对象，连接到邮箱服务器
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.163.com");//设置服务器地址  
        props.put("mail.store.protocol","smtp");//设置协议  
        props.put("mail.smtp.port",25);//设置端口  
        props.put("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                /**
                 * 创建一个邮箱账号
                 */
                return new PasswordAuthentication("hjh0370@163.com", "hjh1995828");
            }

        });

        // 2.创建邮件对象
        Message message = new MimeMessage(session);
        // 2.1设置发件人
        /**
         * "hjh0370@163.com"是一个字符串，将字符串转换成地址
         */
        message.setFrom(new InternetAddress("hjh0370@163.com"));

        // 2.2设置收件人
        message.setRecipient(RecipientType.TO, new InternetAddress(to));

        // 2.3设置邮件主题
        message.setSubject("乐途影评验证邮件！");
        message.setSentDate(new Date());
        // 2.4设置邮件正文
        /**
         * ?validateUrl="+validateUrl+" :表示从外面传入一个验证超链接
         */
        message.setContent(
                "<h1>乐途影评</h1>邮箱验证请点击以下链接： <h3><a href='http://localhost:8090/"
                        + validateUrl + "'>http://localhost:8090/" + validateUrl + "</a></h3>",
                "text/html;charset=UTF-8");

        // 3.发送一封激活邮件
        Transport.send(message);
    }
}
