package com.businessOracle.businessOracle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.businessOracle.businessOracle.mapper"})
@RestController
@EnableScheduling
public class businessOracleApplication {
    public static void main(String[] args) {
        SpringApplication.run(businessOracleApplication.class, args);
    }
}
