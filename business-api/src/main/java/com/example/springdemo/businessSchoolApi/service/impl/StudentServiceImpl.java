package com.example.springdemo.businessSchoolApi.service.impl;

import com.example.springdemo.businessSchoolApi.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchoolApi.data.entity.Student;
import com.example.springdemo.businessSchoolApi.data.vo.StudentVo;
import com.example.springdemo.businessSchoolApi.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto) {
        return null;
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public PageInfo<StudentVo> getStudentByRedis(SearchStudentSearchDto searchStudentDto) {
        return null;
    }
}
