package com.thinkInJava.book.Thread.Model10;

import lombok.extern.slf4j.Slf4j;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 17:11 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
public class MyThreadImplement implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            log.info("实现Runnable接口的创建线程方法" + Thread.currentThread().getName() + " " + i);
        }
    }
}
