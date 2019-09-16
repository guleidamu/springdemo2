package com.example.springdemo.businessSchool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.example.springdemo.businessSchool.mapper"})
@RestController
@EnableScheduling
public class BusinessSchoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessSchoolApplication.class, args);
    }
}
