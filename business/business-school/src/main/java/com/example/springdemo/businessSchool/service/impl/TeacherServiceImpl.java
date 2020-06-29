package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.entity.Teacher;
import com.example.springdemo.businessSchool.mapper.TeacherMapper;
import com.example.springdemo.businessSchool.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:17 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }
}
