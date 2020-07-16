package com.springdemo.spring_jpa.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:03 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Student implements Serializable {
    private String id;
    private  String name;
    private String age;
}