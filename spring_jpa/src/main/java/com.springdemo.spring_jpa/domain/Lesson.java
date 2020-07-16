package com.springdemo.spring_jpa.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:06 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Lesson implements Serializable {
    private String id;
    private String name;
    private String teacher;
    private  float credit;
}