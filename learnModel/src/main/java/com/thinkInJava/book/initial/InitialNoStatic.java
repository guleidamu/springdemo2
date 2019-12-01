package com.thinkInJava.book.initial;

public class InitialNoStatic {
    public static void main(String[] args) {
        InitialNoStatic intNoS = new InitialNoStatic(); ////需实例化A的对象后才可以调用A中非静态方法
        intNoS.fun();
    }

    public void fun(){
        System.out.println("这是一个非静态方法");
    }
}
