package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:19 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Component
public interface TeacherMapper {

    void insertTeacher(Teacher teacher);
}
