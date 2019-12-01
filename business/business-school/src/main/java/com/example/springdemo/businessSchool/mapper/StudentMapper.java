package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.entity.Course;
import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.data.vo.DynamicStudentVo;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudentMapper {
    List<StudentVo> getStudentByName(@Param("sname") String sname);

    ArrayList<DynamicStudentVo> getDynamicStudent(DynamicDto dynamicDto);

    int insertStudent(Student student);

    int insertCourse(Course course);
}
