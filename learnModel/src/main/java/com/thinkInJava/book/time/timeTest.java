package com.thinkInJava.book.time;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class timeTest {

    public static void main(String arg[]){
        Date date1 = new Date();
        Date date2 = new Date();
        //格式化 线程不安全
        //SmpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date1);
        log.info("这个是Date和SimpleDateFormat之间的时间转换time " + time);
        System.out.println();
        //线程安全
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime ldt = LocalDateTime.parse("2019-09-09 18:13:26",df);
        String localTime = df.format(localDateTime);
        log.info("LocalDateTime还有DateTimeFormatter之间的时间转换 LocalDateTime转成String类型的时间localTime" + localTime);
        log.info("String类型的时间转换成LocalDateTime：" + ldt);

        long cha1 = date1.getTime() ;
        long cha2 = date2.getTime();
        double chazhi = (cha1 - cha2)/1000;
        System.out.println("chazhi:"+chazhi);

        double k = 2.6882;
        k = (double)Math.round(k*100)/100;
        double m = 2.6685;
        m = (double)Math.round(m*1000)/1000;
        double w = 0;
        w = (double)Math.round(w*1000)/1000;
        System.out.println("k" + k);
        System.out.println("m "+m);
    }
}
