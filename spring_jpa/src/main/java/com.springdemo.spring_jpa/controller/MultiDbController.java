package com.springdemo.spring_jpa.controller;

import com.springdemo.spring_jpa.dao.first.LessonMapper;
import com.springdemo.spring_jpa.dao.second.StudentMapper;
import com.springdemo.spring_jpa.domain.Lesson;
import com.springdemo.spring_jpa.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:05 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/multidb")
public class MultiDbController {

    @Autowired
    private LessonMapper lessonMapper;
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/getLesson")
    public List<Lesson> getLessons(){
        return lessonMapper.findById(1);
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentMapper.queryStudents();
    }
}
