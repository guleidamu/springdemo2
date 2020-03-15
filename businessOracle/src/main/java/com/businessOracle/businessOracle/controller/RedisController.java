package com.businessOracle.businessOracle.controller;

import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {
    private static int ExpireTime = 60;//redis中存储的过期时间60s
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public boolean redisSet(String key, String value){
        Student student = new Student();
        student.setClassNo("jia");
        student.setStudentName("zhu");
        return redisUtil.set(key,student);
    }

    @RequestMapping("/get")
    public Object redisGet(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("/expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

    @RequestMapping("/addBatch")
    public boolean addBatch(){
        for(int i = 0; i < 500000; i++){
            redisUtil.set("key"+i,i);
        }
        return true;
    }

    @RequestMapping("/AddAsynchronous")
    public boolean AddAsynchronous(int max){
        System.out.println("开始向redis中插入数据！");
        redisUtil.addAsynchronous(max);
        System.out.println("插入数据完毕！");
        return true;
    }
}
