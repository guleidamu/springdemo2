package com.businessOracle.businessOracle.service;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.StudentVo;

import java.util.List;

public interface StudentService {

    List<StudentVo> getStudentByName(SearchStudentDto searchStudentDto);

    int insertStudent(Student student);

    int insertCourse(Course course);
}
