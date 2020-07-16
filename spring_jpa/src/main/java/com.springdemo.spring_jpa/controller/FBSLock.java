package com.springdemo.spring_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 21:39 2020/7/5
 * @ Modified By：
 * @Version: 1.0.0
 */

@RestController
//学习一下RestController 和Controller的区别
//@Controller
@RequestMapping("/FBSLock")
public class FBSLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/deduct_stock")
    public String deductStock() throws InterruptedException {
        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
        //单体服务加锁成功，如果是集群则失败，因为synchronized是针对jvm
        synchronized (this) {
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存" + realStock + "");
            } else {
                System.out.println("扣减失败，库存不足");
            }
            return "end";
        }
    }

    @RequestMapping("/deduct_stockFBS")
    public String deduct_stockFBS() throws InterruptedException {
        String lockKey = "product_001";

        //唯一标识
        String clientId = UUID.randomUUID().toString();
        //加锁
        try {
//            //redis是单线程的。stringRedisTemplate.opsForValue().setIfAbsent("lockKey","damu");这行是有key的话设置value，返回true。没有key返回false，设置value
//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "damu");
//            //万一服务宕机，可能会出现死锁.设置超时时间
//            stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);
            //上面那两行的结合，原子性
            //当业务时间大于锁的时间，会出现把别人的锁给删掉。
            // 比如线程一这个方法（大流程）总共需要16秒，执行到第12秒的时候，锁过期了，第二个线程进来执行加锁。
            // 第一个线程执行12-16秒的程序，释放锁（会关闭了第二个线程的锁）。高并发的情况下可能会永久失效，出现超卖
            //所以要加个唯一锁
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);

            if (!result) {
                return "当前抢购太多，请待会再试";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stocket", realStock + "");
                System.out.println("扣减成功，剩余库存" + realStock + "");
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {
            if(clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                //当业务时间大于锁的时间，会出现把别人的锁给删掉。
                // 比如线程一这个方法（大流程）总共需要16秒，执行到第12秒的时候，锁过期了，第二个线程进来执行加锁。
                // 第一个线程执行12-16秒的程序，释放锁（会关闭了第二个线程的锁）。高并发的情况下可能会永久失效，出现超卖
                //所以要求删的锁是唯一的，即是上面自己加的锁
                //释放锁
                stringRedisTemplate.delete(lockKey);
            }

        }
        return "end";

    }
}
