package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.entity.Teacher;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.TeacherService;
import com.example.springdemo.businessSchool.service.MyThread;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:11 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/helpYourSelf")
public class HelpYourSelf {

    @Resource
    private TeacherService teacherService;

    @PostMapping(value="/addTeacher")
    public Result getDynamicStudent(){
        Teacher teacher = new Teacher();
        teacher.setSchoolName("helpYourSelf");
        teacher.setDescription("做一个测试用的");
        teacher.setPicUrl("图片地址");
        teacher.setRemark("备注一下下");
        teacher.setTeacherName("老师名称");
        teacher.setTeacherPassword("密码");
        teacherService.addTeacher(teacher);
        return ResultBuilder.success();
    }

    @PostMapping(value="/addTeacherByThread")
    public Result addTeacherByThread(){
        for (int i = 1; i <=5; i++){
            new MyThread().start();
        }
//        new MyThread().start();

        return null;
    }




}
