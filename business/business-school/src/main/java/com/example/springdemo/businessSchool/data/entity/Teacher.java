package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:13 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
@Data
public class Teacher {

    private Long id;

    private String teacherName;

    private String teacherPassword;

    private String sex;

    private String description;

    private String picUrl;

    private String schoolName;

    private Date registDate;

    private String remark;
}
