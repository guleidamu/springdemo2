package com.example.springdemo.businessSchool.config.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
       return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                System.out.println("keyGenerator的值"+method.getName() + "[" + Arrays.asList(objects).toString()+"]");
                return method.getName() + "[" + Arrays.asList(objects).toString()+"]";
            }
        };

    }
}
