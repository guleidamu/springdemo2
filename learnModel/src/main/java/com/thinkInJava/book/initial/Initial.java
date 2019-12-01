package com.thinkInJava.book.initial;

public class Initial {

    private static String str5;
    private static String str6 ="";
    private static String str7 = null;
    private static boolean flag;
    private static byte byteData;
    private static short shortData;
    private static int num;
    private static long longData;
    private static float floatData;
    private static double doubleData;
    private static char charData;

    private String str1 = "meili";
    private boolean flag1;
    private byte byteData1;
    private short shortData1;
    private int num1;
    private long longData1;
    private float floatData1;
    private double doubleData1;
    private char charData1;

    private int numb2;
    public static void main(String str[]){
        System.out.println("str5:" + str5);
        System.out.println("str6:" + str6);
        System.out.println("str7:" + str7);
        System.out.println("flag:" + flag);
        System.out.println("byteData:" + byteData);
        System.out.println("shortData:" + shortData);
        System.out.println("num:" + num);
        System.out.println("longData:" + longData);
        System.out.println("floatData:" + floatData);
        System.out.println("doubleData:" + doubleData);
        System.out.println("charData:" + charData);
    }
    static {
        int numb3 = 0;
        System.out.println("numb3" + numb3);
        //System.out.println("numb3" + numb2);  静态方法不能引用非静态变量。
    }

    public void getInitialValue(){
        System.out.println(this.getClass()+"初始化数据");
        System.out.println("str1:" + str1);
        System.out.println("flag1:" + flag1);
        System.out.println("byteData1:" + byteData1);
        System.out.println("shortData1:" + shortData1);
        System.out.println("num1:" + num1);
        System.out.println("longData1:" + longData1);
        System.out.println("floatData1:" + floatData1);
        System.out.println("doubleData1:" + doubleData1);
        System.out.println("charData1:" + charData1);

    }
}
