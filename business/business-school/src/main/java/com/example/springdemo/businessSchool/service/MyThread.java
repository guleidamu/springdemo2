package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.entity.Teacher;
import com.example.springdemo.businessSchool.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:57 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Component
public class MyThread extends Thread{

    @Resource
    private TeacherMapper teacherMapper;

    public static MyThread myThread;

    @PostConstruct
    public void init(){
        myThread = this;
    }

    public void addTeacher(Teacher teacher) {
//        for(int i = 0; i < 10000; i++){
//            teacher.setSchoolName("helpYourSelf");
//            teacher.setDescription("做一个测试用的");
//            teacher.setPicUrl("图片地址" + i);
//            teacher.setRemark("备注一下下");
//            teacher.setTeacherName("老师名称");
//            teacher.setTeacherPassword("密码");
//            teacherMapper.insertTeacher(teacher);
//        }

    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            log.info("当前线程名称：" + Thread.currentThread().getName());
            Teacher teacher = new Teacher();
            teacher.setSchoolName("helpYourSelf");
            teacher.setDescription("做一个测试用的");
            teacher.setPicUrl("图片地址" + i);
            teacher.setRemark("备注一下下" + i);
            teacher.setTeacherName("老师名称");
            teacher.setTeacherPassword("密码");
            //通过这种方法直接调取，mapper空指针。teacherMapper.insertTeacher(teacher);
            myThread.teacherMapper.insertTeacher(teacher);
        }
    }
}
