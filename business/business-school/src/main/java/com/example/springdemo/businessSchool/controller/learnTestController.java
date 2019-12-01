package com.example.springdemo.businessSchool.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Api(description = "测试使用的接口")
@RestController
@RequestMapping(value = "/student")
public class learnTestController {

    @PostMapping(value = "/exportExcel")
    public void downloadDatas (@RequestBody Map map, HttpServletResponse response) throws IOException {

    }
}
