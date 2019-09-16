package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.vo.DynamicStudentVo;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto);

    ArrayList<DynamicStudentVo> getDynamicStudent(DynamicDto dynamicDto);
}
