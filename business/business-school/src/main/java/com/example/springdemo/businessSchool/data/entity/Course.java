package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {

    private String courseNo;

    private String courseName;

    private String teacherNo;
}
