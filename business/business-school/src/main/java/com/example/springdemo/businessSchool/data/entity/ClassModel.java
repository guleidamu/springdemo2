package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClassModel implements Serializable {

    private Long classNo;

    private String className;

    private String masterName;

    private Long testLong;

    List<Student> studentList;

    private Student student;
}
