package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;



@Data
public class Student implements Serializable {

    private Integer studentNo;

    private String studentName;

    private String studentSex;

    private String classNo;

    private String courseNo;

    private String courseName;

    private String teacherNo;

    private String param;
}
