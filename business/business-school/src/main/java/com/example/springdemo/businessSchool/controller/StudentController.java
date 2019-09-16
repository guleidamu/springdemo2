package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.data.dict.LogRecord;
import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @LogRecord
    @ApiOperation(value = "通过学生名称获取学生信息", notes = "新增学生名称获取学生信息1")
    @PostMapping(value = "/getStudent")
    public Result<PageInfo<StudentVo>> getStudent(@Valid @RequestBody SearchStudentSearchDto searchStudentDto) {
        PageInfo<StudentVo> result = studentService.findStudentByName(searchStudentDto);
        return ResultBuilder.success(result);
    }

    @PostMapping(value="/getDynamicStudent")
    public Result getDynamicStudent(@RequestBody DynamicDto dynamicDto){
        Result result = new Result();
        result.setData(studentService.getDynamicStudent(dynamicDto));
        return result;
    }


}
