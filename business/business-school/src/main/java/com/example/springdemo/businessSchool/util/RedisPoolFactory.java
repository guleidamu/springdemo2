package com.example.springdemo.businessSchool.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 15:01 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */

//@Service
@Configuration
public class RedisPoolFactory {

    @Autowired
    RedisConfigBySecKill redisConfig;

    //通过@Bean注解告诉方法，产生一个Bean对象，然后将这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，
    // 随后这个Spring将会将这个Bean对象放在自己的IOC容器中
    @Bean
    public JedisPool JedisPoolFactoryConnection() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
                redisConfig.getTimeout()*1000, redisConfig.getPassword(), 6);
        return jp;
    }
}
