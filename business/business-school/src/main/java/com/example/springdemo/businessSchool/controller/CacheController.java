package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.data.dict.LogRecord;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.feign.BusinessOracleClient;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 快速体验缓存
 * b步骤
 *  1，开启基于注解的缓存@EnableCacheing
 *  2，标注缓存注解即可
 */
@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/studentCache")
@EnableCaching
public class CacheController {

    @Resource(name = "StudentServiceCacheImpl")
    private StudentService studentService;


    @Value("${file.upload}")
    private String filePath;

    @Value("${file.upload}")
    private String downLoadFilePath;

    @LogRecord
    @ApiOperation(value = "通过学生名称获取学生信息", notes = "获取学生信息")
    @PostMapping(value = "/getStudent")
    public Result<PageInfo<StudentVo>> getStudent(@Valid @RequestBody SearchStudentSearchDto searchStudentDto) {
        PageInfo<StudentVo> result = studentService.findStudentByName(searchStudentDto);
        return ResultBuilder.success(result);
    }

}
