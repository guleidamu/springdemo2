package com.businessOracle.businessOracle.service;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.SchoolClassVo;
import com.businessOracle.businessOracle.data.vo.StudentVo;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

    ArrayList<StudentVo> getStudentByName(SearchStudentDto searchStudentDto);

    int insertStudent(Student student);

    int insertCourse(Course course);

    ArrayList<SchoolClassVo> querySchoolClassAndStudents(String teacherName);
}
