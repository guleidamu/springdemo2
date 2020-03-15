package com.example.springdemo.businessSchool.service.impl;

import com.alibaba.fastjson.JSONObject;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate; //操作k - v都是字符串的

    @Resource
    RedisTemplate redisTemplate; //key - value 都是对象

//    @Resource
//    MyRedisConfigTest myRedisConfigTest;

    @Resource
    RedisTemplate<Object, Object> RedisTemplateSer;

    // String字符串  list列表  set集合  hash散列 zSet有序集合
    //stringRedisTemplate.opsForValue();字符串
    //stringRedisTemplate.opsForHash();hash
    //stringRedisTemplate.opsForList();list
    //stringRedisTemplate.opsForSet();set
    //stringRedisTemplate.opsForZSet();zSet
    public void testRedis1(){
        stringRedisTemplate.opsForHash();
    }

    @Override
    public PageInfo<StudentVo> getStudentByRedis(SearchStudentSearchDto searchStudentDto) {
        log.info("searchStudentDto: " +searchStudentDto +"转json"+ JSONObject.toJSONString(searchStudentDto));
        PageHelper.startPage(searchStudentDto.getPageCode(),searchStudentDto.getPageSize());
        List<StudentVo> list = studentMapper.getStudentByName(searchStudentDto.getSname());
        redisTemplate.opsForValue().set("studentDtoT1",JSONObject.toJSONString(searchStudentDto));
        RedisTemplateSer.opsForValue().set("studentDtoT1",searchStudentDto);
//        myRedisConfigTest.RedisTemplateSer().set("studentDtoT1",searchStudentDto);
        PageInfo<StudentVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    //通过@Cacheable缓存
    @Cacheable(value = {"studentVo"}, key="#searchStudentDto.sname")
    public PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto) {
        log.info("searchStudentDto: " +searchStudentDto);
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
        return 0;
    }




}
