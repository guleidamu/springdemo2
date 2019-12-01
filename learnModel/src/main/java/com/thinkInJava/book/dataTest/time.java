package com.thinkInJava.book.dataTest;

import java.util.Date;

public class time {

    public static void main(String arg[]){
        try {
            Date a = new Date();
            Thread.sleep(3000);
            Date b = new Date();
            long interval = (b.getTime() - a.getTime())/1000;
            System.out.println("两个时间相差"+interval+"秒");//会打印出相差3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
