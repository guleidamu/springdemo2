package com.thinkInJava.book.Thread.Model9;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 15:01 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int x = 0; x < 10; x++){
            System.out.println("线程名称：" + Thread.currentThread().getName() + ":" +x);
        }
    }
}
