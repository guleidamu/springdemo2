package com.businessOracle.businessOracle.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
public class SendEMailUtil {

//    @Autowired
//    private JavaMailSender mailSender;

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    public void setSimpleMail() throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("guleidamu@163.com");
        message.setTo("guleidamu@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }
}
