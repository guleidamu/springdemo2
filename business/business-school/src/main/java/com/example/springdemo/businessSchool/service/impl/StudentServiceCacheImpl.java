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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("StudentServiceCacheImpl")
public class StudentServiceCacheImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    /**
     * 将方法的运行结果进行缓存，以后要相同的数据，之间缓存获取，不用调用方法
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作,每个缓存组件有自己唯一一个名字
     * 几个属性
     *  cacheName/values 指定缓存的名字，将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存
     *  key：缓存数据使用key；可以用他来指定。默认是使用方法参数的值，1
     *      编写SpEL,#id,参数id的值，#a0,#p0 #root.args[0]
     *      keyGenerator: key的生成器，可以自己指定key的生成器的组件id
     *      key/keyGenerator  二选一
     *      cacheManager:指定缓存管理器；或者cacheResolver获取解析器
     *      condition:指定符合条件的情况下才缓存 condition = "#id>0:第一个参数大于1的情况下才缓存
     *      unless：否定缓存，当unless指定的条件未true，方法的返回值就不会呗缓存，可以取到结果进行判断
     *          unless = "#result ==null"
     *      sync ：是否使用异步模式
     *  原理
     *      1，自动配置类，
     *      2, 缓存的配置类11个
     *      3，哪个配置类生效：SimpleCacheConfiguration
     *      4，给容器中注册了一个CacheManager；ConcurrentMapCacheManager
     *      5，如果获取和创建ConcurrentMapCache类型的缓存组件，他的作用将数据存储在ConcurrentMap中
     *
     *      运行流程
     *
     * @param searchStudentDto
     * @return
     */
    @Override
        @Cacheable(value = {"studentVo"}, keyGenerator="myKeyGenerator")
//    @Cacheable(value = {"studentVo"}, key="#searchStudentDto.sname")
//    @Cacheable(value = {"studentVo"}, key="#root.methodName+'['+#searchStudentDto.sname+']'")
//    @Cacheable(cacheNames = "student")//key默认是参数的值
    public PageInfo<StudentVo> findStudentByName(SearchStudentSearchDto searchStudentDto) {
        log.info("查询：searchStudentDto: " +searchStudentDto);
        PageHelper.startPage(searchStudentDto.getPageCode(),searchStudentDto.getPageSize());
        List<StudentVo> list = studentMapper.getStudentByName(searchStudentDto.getSname());
        PageInfo<StudentVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
        return 0;
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
