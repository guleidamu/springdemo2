package com.businessOracle.businessOracle.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {

    private String courseNo;

    private String courseName;

    private String teacherNo;

    public Course(){}

    public Course(String courseNo, String courseName, String teacherNo){
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.teacherNo = teacherNo;
    }

}
