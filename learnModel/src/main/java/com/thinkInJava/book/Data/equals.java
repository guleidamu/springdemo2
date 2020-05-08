package com.thinkInJava.book.Data;

import java.math.BigDecimal;

public class equals {

    public static void main(String[] args) {
        double a = 3*0.1;
        double b= 0.3;
        double c= 0.3;
        int d = 3;
        int e = 3;
        int f = 5;
        BigDecimal bigDecimal1 = new BigDecimal("3");
        //BigDecimal bigDecimal1 = new BigDecimal(3);对象里面的值有没有引号结果不一样
        BigDecimal bigDecimal2 = new BigDecimal("0.1");
        System.out.println("bigDecimal1.multiply(bigDecimal2)" + bigDecimal1.multiply(bigDecimal2));
        System.out.println("bigDecimal1.multiply(bigDecimal2)" + bigDecimal1.multiply(bigDecimal2).doubleValue());
        System.out.println("3*0.1=" + 3*0.1);
        System.out.println("a" + a);
        if(3*0.1== 0.3){
            System.out.println("3*0.1== 0.3" + "t");
        } else {
            System.out.println("3*0.1== 0.3" + "F");
        }

        if(a== b){
            System.out.println("a== b" + "t");
        } else {
            System.out.println("a== b" + "F");
        }

        if(c== b){
            System.out.println("c== b" + "t");
        } else {
            System.out.println("c== b" + "F");
        }

        if(d== e){
            System.out.println("d== e" + "t");
        } else {
            System.out.println("d== e" + "F");
        }

        if(d== f){
            System.out.println("d== f" + "t");
        } else {
            System.out.println("d== f" + "F");
        }
    }
}
