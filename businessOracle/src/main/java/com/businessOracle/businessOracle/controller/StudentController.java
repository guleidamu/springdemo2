package com.businessOracle.businessOracle.controller;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import com.businessOracle.businessOracle.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/Oracle")
public class StudentController {

    @Resource
    private StudentService studentService;

    @ApiOperation(value = "通过学生名称获取学生信息", notes = "新增学生名称获取学生信息1")
    @PostMapping(value = "/getStudent")
    public List<StudentVo> getStudent(@Valid @RequestBody SearchStudentDto searchStudentDto) {
        return studentService.getStudentByName(searchStudentDto);
    }
}
