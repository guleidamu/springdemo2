package com.example.springdemo.businessSchool.feign;

import com.example.springdemo.businessSchool.data.dto.SearchStudentDto;
import com.example.springdemo.businessSchool.response.Result;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name ="business-oracle-school",fallback = BusinessOracleClientHystric.class)
@FeignClient(name ="business-oracle-school")
public interface BusinessOracleClient {

    //如果参数是String等数据参数，要添加注解（RequestParam());
    @PostMapping(value = "/Oracle/getStudent")
    Result getStudent(@RequestBody SearchStudentDto searchStudentDto);

}
