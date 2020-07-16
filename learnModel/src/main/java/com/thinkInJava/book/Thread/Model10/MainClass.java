package com.thinkInJava.book.Thread.Model10;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 16:37 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class MainClass {

    public static void main(String[] args) {
        //run()和start()的区别
        //run():仅仅是封装被线程执行的代码，直接调用是普通方法，是单线程的。
        //start():首先启动了线程，然后再由jvm去调用该线程的run（）方法。

        //myThreadTest.start();2次会报错， IllegalThreadStateException:非法的线程状态异常
        // 因为start()2次相当于是线程被调用了2次，而不是2个线程启动。
        //一个线程只能调用一次

        MyThreadTest myThreadTest = new MyThreadTest("关之琳");
        myThreadTest.start();

        MyThreadTest myThreadTest1 = new MyThreadTest();
        myThreadTest1.start();
//        for (int i = 1; i<= 10; i++){
//            MyThreadTest myThreadTest2 = new MyThreadTest();
//            myThreadTest2.start();
//        }

    }
}
