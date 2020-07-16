package com.example.springdemo.businessSchool;

import org.mybatis.spring.annotation.MapperScan;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;


@ServletComponentScan
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.example.springdemo.businessSchool.mapper"})
@RestController
@EnableScheduling
@EnableFeignClients
public class BusinessSchoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessSchoolApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Redisson redission(){
        //此为单机模式
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
