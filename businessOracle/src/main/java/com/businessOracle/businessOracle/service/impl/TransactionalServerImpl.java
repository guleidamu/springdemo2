package com.businessOracle.businessOracle.service.impl;

import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.mapper.StudentMapper;
import com.businessOracle.businessOracle.service.TransactionalServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionalServerImpl implements TransactionalServer {

    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public int addData() {
        Integer id = studentMapper.studentSeq();
        Student student = new Student("zhangFei","guanYu", id);
        Course course = new Course(id.toString(),"shuxue","626");
        studentMapper.insertStudent(student);
        studentMapper.insertCourse(course);
        return 0;
    }

    @Override
    public int addStudent(Student student) {

        return 0;
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }
}
