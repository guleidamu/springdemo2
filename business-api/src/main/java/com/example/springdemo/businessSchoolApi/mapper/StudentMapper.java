package com.example.springdemo.businessSchoolApi.mapper;


import com.example.springdemo.businessSchoolApi.data.entity.Student;
import com.example.springdemo.businessSchoolApi.data.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudentMapper {
    List<StudentVo> getStudentByName(@Param("sname") String sname);

//    ArrayList<DynamicStudentVo> getDynamicStudent(DynamicDto dynamicDto);

    int insertStudent(Student student);

//    int insertCourse(Course course);
}
