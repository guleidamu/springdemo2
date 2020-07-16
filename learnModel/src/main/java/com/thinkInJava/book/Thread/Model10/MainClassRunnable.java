package com.thinkInJava.book.Thread.Model10;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 17:15 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class MainClassRunnable {

    public static void main(String[] args) {
        MyThreadImplement myThreadImplement = new MyThreadImplement();
        Thread thread1 = new Thread(myThreadImplement);
        Thread thread2 = new Thread(myThreadImplement);
        thread1.start();
        thread2.start();
    }
}
