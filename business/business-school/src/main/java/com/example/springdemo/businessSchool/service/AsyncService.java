package com.example.springdemo.businessSchool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:41 2020/6/28
 * @ Modified By：
 * @Version: 1.0.0
 */
@Service
public class AsyncService {

    @Async
    public void executeAsync1(){
        try {
            Thread.sleep(20);
            System.out.println("异步任务：：1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void executeAsync2(){
        System.out.println("异步任务：：2");
    }

}
