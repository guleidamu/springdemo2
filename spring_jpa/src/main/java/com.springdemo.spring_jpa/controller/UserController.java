package com.springdemo.spring_jpa.controller;

import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.springdemo.spring_jpa.domain.User;
import com.springdemo.spring_jpa.service.UserJpaService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 12:46 2020/7/2
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/userJpa")
public class UserController {

    @Resource
    private UserJpaService userJpaService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userJpaService.save(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user){
        userJpaService.update(user);
    }

    @PostMapping("/getUser")
    public Result getUser(@RequestBody User user){
        return ResultBuilder.success(userJpaService.getUser(user));
    }

    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestBody User user){
        return ResultBuilder.success(userJpaService.deleteUser(user));
    }
}
