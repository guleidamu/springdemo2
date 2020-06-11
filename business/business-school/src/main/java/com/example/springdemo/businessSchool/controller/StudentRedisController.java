package com.example.springdemo.businessSchool.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springdemo.businessSchool.data.dict.LogRecord;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.mapper.StudentMapper;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(description = "学生信息接口,测试redis")
@RestController
@RequestMapping(value = "/studentRedis")
@EnableCaching
public class StudentRedisController {


    @Resource(name = "StudentServiceRedisImpl")
    private StudentService studentService;

    private StudentMapper studentMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串
//
//    @Autowired
//    private RedisTemplate redisTemplate; //k-v都是对象

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    RedisTemplate<String, Object> redisTemplateSer;

    @Resource
    RedisTemplate<String, Object> redisTemplateSerializable;


    @LogRecord
    @ApiOperation(value = "通过学生名称获取学生信息", notes = "新增学生名称获取学生信息1")
    @PostMapping(value = "/getStudent")
    public Result<PageInfo<StudentVo>> getStudent(@Valid @RequestBody SearchStudentSearchDto searchStudentDto) {
        PageInfo<StudentVo> result = studentService.findStudentByName(searchStudentDto);
        return ResultBuilder.success(result);
    }

    @PostMapping(value = "/redisTest0")
    public void redisTest0(){
        //string读写
        stringRedisTemplate.opsForValue().append("msg","damu");
        System.out.println("写入redis" + "msg ， damu");
        String msgValue = stringRedisTemplate.opsForValue().get("msg");
        System.out.println("读取的msgValue" + msgValue);

    }

    @PostMapping(value = "/redisTest1")
    public void redisTest1(){
        //string读写
//        stringRedisTemplate.opsForValue().append("msg","damu");
//        System.out.println("写入redis" + "msg ， damu");
//        String msgValue = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println("读取的msgValue" + msgValue);
        //list
        stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("myList","2");

    }

    @PostMapping(value = "/redisTest3")
    public void redisTest3(@Valid @RequestBody SearchStudentSearchDto searchStudentDto) {
        Student student = new Student();
        student.setStudentName("kaiXin");
        student.setStudentNo(23);
        student.setParam("23");
        PageInfo<StudentVo> result = studentService.findStudentByName(searchStudentDto);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中

        //1.将数据以json 的方式保存
        //(1),将json对象转换为json
//        stringRedisTemplate.opsForValue().set("yi",JSON.toJSONString(student));
        //（2），将redisTemplate的默认序列化规则,改变默认的序列化规则
//        redisTemplate.opsForValue().set("yiEr",student);
//        redisTemplate.opsForValue().set("san",student);
        redisTemplate.opsForValue().set("wu",student);
        redisTemplateSer.opsForValue().set("liu",student);
        redisTemplateSerializable.opsForValue().set("qi",student);
        String yiValue = stringRedisTemplate.opsForValue().get("yi");
        System.out.println("yiValue" + yiValue);
        Student student1 = null;
        student1 = JSONObject.parseObject(yiValue,Student.class);
        System.out.println("student1" + student1);
    }


    @PostMapping(value = "/redisGetStudent")
    public String redisGetStudent(){
        //string读写
        Object object = redisTemplate.opsForValue().get("liu");
        Object object1 = redisTemplateSer.opsForValue().get("liu");
        String obj1 = object1.toString();
        Object object2 = redisTemplateSerializable.opsForValue().get("liu");
        return obj1;
    }


}
