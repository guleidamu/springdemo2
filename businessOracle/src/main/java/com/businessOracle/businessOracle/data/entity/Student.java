package com.businessOracle.businessOracle.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {

    private Integer studentNo;

    private String studentName;

    private String studentSex;

    private Date studentBirthday;

    private String updateTime;

    private String createTime;

    private String classNo;

    private String courseNo;

    private String courseName;

    private String teacherNo;

    private String param;

    private Integer no1;

    private Integer no2;
}