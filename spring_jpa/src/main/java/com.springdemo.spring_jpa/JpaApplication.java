package com.springdemo.spring_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 18:22 2020/7/2
 * @ Modified By：
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
