package com.example.springdemo.businessSchool.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api(description = "token数据校验接口")
@RestController
@RequestMapping(value = "/token")
@EnableCaching
public class TokenDataController {


    private static Map<String,Object> tokenData = new HashMap<>();
    private Map<String,Object> tokenData1 = new HashMap<>();
    private static Integer COUNT_D = 0;
    private Integer COUNT_D1 = 0;

    @PostMapping(value = "/getData")
    public Integer getData(@RequestBody Map map){
        String mapKey = map.get("key").toString();
        Object tokenMapValue = tokenData.get("k1");
            tokenData.put(mapKey,COUNT_D);
            tokenData1.put(mapKey,COUNT_D1);
            COUNT_D1++;
            COUNT_D++;
            System.out.println("mapKey:" + COUNT_D1 + ", mapKey" + COUNT_D + ".");

        return Integer.parseInt(tokenMapValue.toString());
    }

    @PostMapping(value = "/getData1")
    public Integer getData1(@RequestBody Map map){
        Object tokenMapValue = tokenData.get("k1");
        tokenData.put("k1",COUNT_D);
        tokenData1.put("k1",COUNT_D1);
        COUNT_D1++;
        COUNT_D++;
        System.out.println("mapKey:" + COUNT_D1 + ", mapKey" + COUNT_D + ".");
        return Integer.parseInt(tokenMapValue.toString());
    }
}
