package com.thinkInJava.book.Thread.Model10;

import lombok.extern.slf4j.Slf4j;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 16:33 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
public class MyThreadTest extends Thread {

    public MyThreadTest(){}

    public MyThreadTest(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            log.info("MyThreadTest" + "继承Thread,名称" + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
