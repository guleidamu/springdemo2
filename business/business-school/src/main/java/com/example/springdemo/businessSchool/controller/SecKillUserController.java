package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.constant.Const;
import com.example.springdemo.businessSchool.constant.redis.UserKey;
import com.example.springdemo.businessSchool.data.dto.UserDTO;
import com.example.springdemo.businessSchool.data.entity.User;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.service.RedisService;
import com.example.springdemo.businessSchool.service.UserService;
import com.example.springdemo.businessSchool.util.MD5Util;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:20 2020/6/22
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Api(description = "秒杀用户登录接口")
@RestController
@RequestMapping(value = "/secKillUser")
public class SecKillUserController {

    @Autowired
    RedisService redisService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody UserDTO userDTO){

        //模拟前端对密码加密
//        String salt = "9d5b364d";
//        String fronPassword = "" + salt.charAt(0) + salt.charAt(2) + userDTO.getPassword() + salt.charAt(5) + salt.charAt(4);
        String passwordByMD5 = MD5Util.inputPassToFormPass(userDTO.getPassword());
        userDTO.setPassword(passwordByMD5);
        Result<User> resultUser = userService.login(userDTO);
        //将登录信息存放到redis
        if(resultUser.isSuccess()){
            //一个不知道要干嘛的String,源代码那边用session.getID();
            String KEY = "DONTKNOWHOWTODO";
            redisService.set(UserKey.getByName, KEY, resultUser.getData(), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        return resultUser;
    }
}
