package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.entity.Course;
import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.data.vo.DynamicStudentVo;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.mapper.StudentMapper;
import com.example.springdemo.businessSchool.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public int addStudent(Student student) {
//        int i = studentMapper.insertStudent(student);
//        Student student1 = new Student();
//        student1.setStudentNo(student.getStudentNo()+1);
//        student1.setStudentSex(student.getStudentSex());
//        student1.setStudentName(student.getStudentName());
//        int k = studentMapper.insertStudent(student1);
//
//        Course course = new Course();
//        course.setCourseNo(student.getCourseNo());
//        course.setCourseName(student.getCourseName());
//        course.setTeacherNo(student.getTeacherNo());
//        addCourse(course);
//        return i;
        return 0;
    }

    @Override
    public int addCourse(Course course) {
//        int j = studentMapper.insertCourse(course);
//        return j;
        return 0;
    }
}
