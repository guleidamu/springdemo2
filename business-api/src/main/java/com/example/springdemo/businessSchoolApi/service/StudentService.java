package com.example.springdemo.businessSchoolApi.service;

import com.example.springdemo.businessSchoolApi.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchoolApi.data.entity.Student;
import com.example.springdemo.businessSchoolApi.data.vo.StudentVo;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

//@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface StudentService {

    PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto);
//
//    ArrayList<DynamicStudentVo> getDynamicStudent(DynamicDto dynamicDto);

    int addStudent(Student student);

//    int addCourse(Course course);

    PageInfo<StudentVo> getStudentByRedis(SearchStudentSearchDto searchStudentDto);
}
