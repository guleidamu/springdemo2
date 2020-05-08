package com.example.springdemo.businessSchool.feign;

import com.example.springdemo.businessSchool.data.dto.SearchStudentDto;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import org.springframework.stereotype.Component;

@Component
public class BusinessOracleClientHystric implements BusinessOracleClient {
    @Override
    public Result getStudent(SearchStudentDto searchStudentDto) {
        return ResultBuilder.success("sorry 调取失败"+searchStudentDto);
    }
}
