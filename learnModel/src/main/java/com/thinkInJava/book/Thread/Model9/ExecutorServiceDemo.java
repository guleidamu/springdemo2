package com.thinkInJava.book.Thread.Model9;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 15:03 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
        // 创建一个线程池对象，控制要创建几个线程对象。
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

        pool.shutdown();
    }
}
