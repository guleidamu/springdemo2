package com.thinkInJava.book.time;

import java.util.Date;

public class timeTest {

    public static void main(String arg[]){
        Date date1 = new Date();
        Date date2 = new Date();

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
