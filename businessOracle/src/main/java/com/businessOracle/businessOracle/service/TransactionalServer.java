package com.businessOracle.businessOracle.service;

import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;

public interface TransactionalServer {

    int addData();

    int addStudent(Student student);

    int addCourse(Course course);
}
