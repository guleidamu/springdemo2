package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.vo.DynamicStudentVo;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.mapper.StudentMapper;
import com.example.springdemo.businessSchool.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto) {
        PageHelper.startPage(searchStudentDto.getPageCode(),searchStudentDto.getPageSize());
        List<StudentVo> list = studentMapper.getStudentByName(searchStudentDto.getSname());
        PageInfo<StudentVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ArrayList<DynamicStudentVo> getDynamicStudent(DynamicDto dynamicDto) {
        return studentMapper.getDynamicStudent(dynamicDto);
    }
}
