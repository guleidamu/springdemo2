package com.thinkInJava.book.MS.Main.CodeBlock;

/**
 * 静态代码块》普通代码块》构造方法
 */

class Code{//随从类
    public Code(){
        System.out.println("Code的构造方法1111");
    }
    {
        System.out.println("Code的构造块2222");
    }
    static {
        System.out.println("Code的静态代码块333");
    }
}

class CodeBlock03 { //主类(先执行主类的static)

    {
        System.out.println("CodeBlack03的构造块444");
    }
    static {
        System.out.println("CodeBlock03的静态代码块555");
    }
    public CodeBlock03() {
        System.out.println("CodeBlock的构造方法");
    }

    public static void main(String[] args) {
        System.out.println("我是美丽的分割线---==-===cocdBlock03的main方法777");
        new Code();
        System.out.println("----");
        //new Code();
        System.out.println("------");
//        new CodeBlock03();
        System.out.println("------");
    }
}


