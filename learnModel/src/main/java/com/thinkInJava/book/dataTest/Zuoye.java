package com.thinkInJava.book.dataTest;

import java.util.Random;

public class Zuoye {
    public static void main(String[] args) {
        Zuoye zuoye = new Zuoye();
        Zuoye zuoye1 = new Zuoye();
        zuoye.No1();
        zuoye.No2();
        zuoye.toString();
        System.out.println(zuoye.toString());
        System.out.println(zuoye);
        System.out.println(zuoye1);
    }

    private void No1() {
        for (int i = 0; i <= 12; i++) {
            int red = 12, gre = 4;
            red = red - i;
            gre = gre + i;
            if (gre == red) {
                System.out.println("红给青" + i + "本书，两人书一样多，有" + red + "本");
                break;
            } else if (red == 0) {
                System.out.println("红将书都给了青，书本都没一样多");
            }
        }
    }
    private void No2() {
        int broA = new Random().nextInt(100);
        int sisA = broA - 7;
        int sis = sisA - 8;
        int bro = broA + 8;
        int temp = bro - sis;
        System.out.println("哥原来比妹多" + temp + "本书");

    }
}
