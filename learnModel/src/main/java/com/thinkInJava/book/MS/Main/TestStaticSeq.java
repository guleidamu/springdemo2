package com.thinkInJava.book.MS.Main;


class Father{
    public Father(){
        System.out.println("父类111111");
    }
    {
        System.out.println("父类22222");
    }
    static {
        System.out.println("父类33333");
    }
}

class Son extends Father{
    public Son(){
        System.out.println("子类44444");
    }
    {
        System.out.println("子类55555");
    }
    static {
        System.out.println("子类666666");
    }
}

public class TestStaticSeq {
    //任何类先加载都加载本类（主类）的静态代码块。
    static {
        System.out.println("主类的static");
    }
    {
        System.out.println("主类的构造代码块");
    }
    {
        System.out.println("主类的构造方法块");
    }
    public static void main(String[] args) {
        System.out.println("77777");//参考CodeBlock03,为什么先执行主类的static，
        new Son();
        System.out.println(">>>>");
        new Son();
        System.out.println(">>>>>>");
        new Father();
    }
}
