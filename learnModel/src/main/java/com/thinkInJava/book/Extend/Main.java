package com.thinkInJava.book.Extend;

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.fatherMethodPublic();
        son.leave1();
        String canshu = "参数";
        son.leave1(canshu);
    }
}
