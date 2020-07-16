package com.thinkInJava.book.Thread.Model11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:49 2020/6/30
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ThreadArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 10000000; i >= 1; i--) {
            list.add(0);
        }
        System.out.println("原集合数量：" + list.size());
        List<Integer> newList = new ArrayList<>();
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (Integer integer : list){
                executorService.submit(()->{
                    newList.add(integer + 1);
                });
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(6, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间：" + (end -start) + "ms");

        System.out.println("新集合数量：" + newList.size());
    }
}
