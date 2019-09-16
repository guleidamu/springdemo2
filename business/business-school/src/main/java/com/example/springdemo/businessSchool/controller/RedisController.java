package com.example.springdemo.businessSchool.controller;


import java.util.concurrent.TimeUnit;

import com.example.springdemo.businessSchool.config.RedisConfig;
import com.example.springdemo.businessSchool.data.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "redis调试测试")
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisConfig redisConfig;

    @GetMapping("/fzp")
    public String fzpString() {
        Object object = redisConfig.getValue("chanzui");
        if ((null == object) || ("" == object)){
            redisConfig.setKey("chanzui", "kongkan");
        }
        return redisConfig.getValue("chanzui");

    }


//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @GetMapping("/testString")
//    public String testString() {
//        stringRedisTemplate.opsForValue().set("name", "louis");
//
//        stringRedisTemplate.delete("name");
//        String name = stringRedisTemplate.opsForValue().get("name");
//        return "the value of key 'name' is : " + name;
//    }
//
//    @GetMapping("/testObject")
//    public String testObject() {
//        StringBuilder result = new StringBuilder();
//        User user = new User("louis", "123");
//        ValueOperations<String, User> operations = redisTemplate.opsForValue();
//        operations.set("sys.user", user);
//        operations.set("sys.user.timeout", user, 1, TimeUnit.SECONDS);    // 设置1秒后过期
//        result.append("过期前：").append("\n");
//        result.append("sys.user=" + operations.get("sys.user")).append("\n");
//        result.append("sys.user.timeout=" + operations.get("sys.user.timeout"));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        result.append("\n").append("过期后：").append("\n");
//        result.append("sys.user=" + operations.get("sys.user")).append("\n");
//        result.append("sys.user.timeout=" + operations.get("sys.user.timeout"));
////        result.append("\n").append("重新设置name的值：").append("\n");
////        stringRedisTemplate.opsForValue().set("name", "peppapig");
////        result.append("name新的值：").append("\n");
////        result.append("name=" + stringRedisTemplate.opsForValue().get("name")).append("\n");
//        return result.toString();
//    }
//
//    @GetMapping("/getUser")
//    @Cacheable(value = "user-key")
//    public User getUser() {
//        User user = new User("louis", "123");
//        System.out.println("用户对象缓存不存在，返回一个新的用户对象。");
//        return user;
//    }
//
//
//
//    public void setKey(String key, String value){
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        ops.set(key,value,1, TimeUnit.MINUTES);//1分钟后过期
//    }
//
//    public String getValue(String key){
//        ValueOperations<String,String> ops = this.stringRedisTemplate.opsForValue();
//        return ops.get(key);
//    }
//
//    @GetMapping("/fzp")
//    public String fzpString() {
//        setKey("chanzui","kongkan");
//        return getValue("chanzui");
//
//    }
}
