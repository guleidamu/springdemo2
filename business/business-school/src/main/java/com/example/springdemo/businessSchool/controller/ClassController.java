package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.data.dto.ClassDTO;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.vo.ClassVO;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.ClassService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(description = "class信息接口")
@RestController
@RequestMapping(value = "/class")
public class ClassController {

    @Resource
    private ClassService classService;

    @PostMapping(value = "/queryClassByMasterName")
    public Result queryClassByMasterName(@RequestBody ClassDTO classDTO) {
        ArrayList<ClassVO> ClassVOList= classService.queryClassByMasterName(classDTO);
        return ResultBuilder.success(ClassVOList);
    }

    @PostMapping(value = "/importClass")
    public Result importClass(@RequestBody ClassDTO classDTO) {

        classService.addClassList();
        return ResultBuilder.success();
    }
}
