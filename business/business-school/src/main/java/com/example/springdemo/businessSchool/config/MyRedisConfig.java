package com.example.springdemo.businessSchool.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.util.List;

@Configuration
public class MyRedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

//    @Bean
//    public RedisTemplate<Object, T> RedisTemplateSer(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, T> template = new RedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<T> ser =new Jackson2JsonRedisSerializer<T>(T.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }


//    @Bean
//    public RedisTemplate<Object, T> RedisTemplateSer(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, T> redisTemplate = new RedisTemplate();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        return redisTemplate;
//    }

//    @Bean
//    public RedisTemplate<Object, SearchStudentDto> RedisTemplateSer(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, SearchStudentDto> template = new RedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<SearchStudentDto> ser =new Jackson2JsonRedisSerializer<SearchStudentDto>(SearchStudentDto.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }

    @Bean
    public RedisTemplate<String, Object> RedisTemplateSer(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> ser =new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setDefaultSerializer(ser);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
}
