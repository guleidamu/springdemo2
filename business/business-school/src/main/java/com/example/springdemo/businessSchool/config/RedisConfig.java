package com.example.springdemo.businessSchool.config;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
        public void setKey(String key, String value){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key,value,30, TimeUnit.SECONDS);//30秒后过期
    }

    public String getValue(String key){
        ValueOperations<String,String> ops = this.stringRedisTemplate.opsForValue();
        return ops.get(key);
    }


}
