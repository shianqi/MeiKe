package com.imudges.meike.utils;


import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
 
/**
 * 
 * @author Qixuan.Chen
 */
public class SendEmail {
     
    public static final String HOST = "smtp.163.com";
    public static final String PROTOCOL = "smtp";   
    public static final int PORT = 25;
    public static final String FROM = "id_for_vb@163.com";//发件人的email
    public static final String PWD = "12345678910";//发件人密码
     
    /**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , "true");
         
        Authenticator authenticator = new Authenticator() {
 
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }
             
        };
        Session session = Session.getDefaultInstance(props , authenticator);
         
        return session;
    }
     
    public static void send(String toEmail , String key) {
    	String host="http://183.175.14.98:8080/MeiKeWeb/activeEmail.action?email="+toEmail+"&key="+key;
    	String content="<div align=\"center\"><h3>美课，你的移动教室！<h3><br></div><h4>亲爱的美课用户，您好：<h4><br><br><h5>请点击链接激活账号：<a href='"+host+"'>"+host+"</a><h5><br>或将该地址复制到浏览器进行激活，该链接有效期为48小时，请及时修改。<h5>";
        Session session = getSession();
        try {
            System.out.println("--send--"+content);
            // Instantiate a message
            Message msg = new MimeMessage(session);
  
            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("账号激活邮件");
            msg.setSentDate(new Date());
            msg.setContent(content , "text/html;charset=utf-8");
  
            //Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
 
}