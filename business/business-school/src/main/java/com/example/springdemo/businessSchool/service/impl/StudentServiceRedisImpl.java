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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("StudentServiceRedisImpl")
public class StudentServiceRedisImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串

    @Autowired
    private RedisTemplate redisTemplate; //k-v都是对象

    /**
     * Redis常见的五大数据类型
     * String（字符串），list（列表），Set（集合），Hash（散列），zSet（有序集合）
     *
     * stringRedisTemplate.opsForValue()
     * stringRedisTemplate.opsForList()
     * stringRedisTemplate.opsForSet()
     * stringRedisTemplate.opsForZSet()
     *
     * @param searchStudentDto
     * @return
     */
    @Override
    public PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto) {
        log.info("searchStudentDto: " +searchStudentDto);
        PageHelper.startPage(searchStudentDto.getPageCode(),searchStudentDto.getPageSize());
        List<StudentVo> list = studentMapper.getStudentByName(searchStudentDto.getSname());
        PageInfo<StudentVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<StudentVo> findStudentListByName(SearchStudentSearchDto searchStudentDto) {
        return null;
    }

    @Override
    public PageInfo<StudentVo> findStudentByNameNoCache(SearchStudentSearchDto searchStudentDto) {
        return null;
    }

    @Override
    public ArrayList<DynamicStudentVo> getDynamicStudent(DynamicDto dynamicDto) {
        return null;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public PageInfo<StudentVo> getStudentByRedis(SearchStudentSearchDto searchStudentDto) {
        return null;
    }
}
