package com.thinkInJava.book.Thread.Model4;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class addUser {

    public static void main(String[] args) {

//        //SmpleDateFormat格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date beginTime = new Date();

        String time = simpleDateFormat.format(beginTime);
        log.info("这个是Date和SimpleDateFormat之间的时间转换time " + time);


//        //线程安全
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.now();


        try {
            Thread.sleep(1000 * 3);
            System.out.println("1 存用户信息到\"用户\"表 成功");

            Thread.sleep(1000 * 5);
            System.out.println("2 存用户上传附件到\"附件\"表 成功");

            Thread.sleep(1000 * 10);
            System.out.println("3 发送邮件通知用户激活 成功");

            Thread.sleep(1000);
            System.out.println("4 注册成功提示");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date endTime = new Date();

        long endTimeSecond = endTime.getTime() ;
        long beginTimeSecond = beginTime.getTime();

        double t1 = (endTimeSecond - beginTimeSecond)/1000;
        System.out.println("等了:"+ t1 + "秒");

        System.out.println("用户已经等的不耐烦了......");
    }
}
