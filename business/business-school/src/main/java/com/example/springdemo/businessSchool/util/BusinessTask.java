package com.example.springdemo.businessSchool.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 13:01 2020/7/5
 * @ Modified By：
 * @Version: 1.0.0
 */
@EnableScheduling
@Component
public class BusinessTask {
    private final static String LOCK_ID = "happyjava";

    @Autowired
    DistributedLock distributedLock;

//    @Scheduled(cron = "0/5 * * * * ? ")
    public void doSomething() {
        distributedLock.addLock("y");
        boolean lock = distributedLock.getLock(LOCK_ID, 10 * 1000);
        if (lock) {
            System.out.println("执行任务");
            distributedLock.releaseLock(LOCK_ID);
        } else {
            System.out.println("没有抢到锁");
        }
    }
}