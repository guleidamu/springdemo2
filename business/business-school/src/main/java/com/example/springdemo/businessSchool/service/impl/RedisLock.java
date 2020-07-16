package com.example.springdemo.businessSchool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 12:32 2020/7/5
 * @ Modified By：
 * @Version: 1.0.0
 */
@Service
public class RedisLock {

    private String lock_key = "redis_lock";

    protected long internalLockLeaseTime = 30000;

    private long timeout = 999999; //获取锁的超时时间

    @Autowired
    JedisPool jedisPool;

//    //SET命令的参数
//    SetParams params = SetParams.setParams().nx().px(internalLockLeaseTime);
}
