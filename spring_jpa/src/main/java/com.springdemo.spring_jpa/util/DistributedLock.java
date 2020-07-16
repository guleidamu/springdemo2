package com.springdemo.spring_jpa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 12:55 2020/7/5
 * @ Modified By：
 * @Version: 1.0.0
 */
@Component
public class DistributedLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获得锁
     */
    public boolean getLock(String lockId, long millisecond) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success != null && success;
    }

    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }

    public void addLock(String lockId) {
        redisTemplate.opsForValue().set("yyy","yyy");
    }
}
