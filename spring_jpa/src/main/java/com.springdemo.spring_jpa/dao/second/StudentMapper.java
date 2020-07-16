package com.springdemo.spring_jpa.dao.second;

import com.springdemo.spring_jpa.domain.Student;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:02 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface StudentMapper {
    List<Student> queryStudents();
}
