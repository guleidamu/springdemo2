package com.businessOracle.businessOracle.config;


import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfigTest {


    @Bean
    public RedisTemplate<Object, T> RedisTemplateSer(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, T> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<T> ser =new Jackson2JsonRedisSerializer<T>(T.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}
