package com.thinkInJava.book.Thread.Model10;

import java.util.concurrent.*;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 18:40 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class MyCallable implements Callable<Integer> {

    private int number;

    public MyCallable(int number){
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int x = 1; x <= number; x++){
            sum += x;
        }
        return sum;
    }
}

class CallableDemo{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = pool.submit(new MyCallable(100));
        Future<Integer> f2 = pool.submit(new MyCallable(200));
        Integer i1 = f1.get();
        Integer i2 = f2.get();
        System.out.println(i1);
        System.out.println(i2);
        pool.shutdown();
    }
}
