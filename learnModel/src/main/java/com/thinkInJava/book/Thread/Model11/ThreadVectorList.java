package com.thinkInJava.book.Thread.Model11;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:15 2020/6/30
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ThreadVectorList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 10000000; i >= 1; i--){
            list.add(0);
        }
        System.out.println("源集合数量：" + list.size());
        List<Integer> newVector = new Vector<>();
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (Integer integer : list){
            executorService.submit(()->{
                newVector.add(integer + 2);
            });
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(6, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("时间:"+(end-start)+"ms");

        System.out.println("newVector数量:"+newVector.size());
    }
}
