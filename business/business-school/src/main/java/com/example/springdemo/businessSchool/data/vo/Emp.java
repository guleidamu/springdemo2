package com.example.springdemo.businessSchool.data.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Emp {

    private Integer empId;

    private String empName;

    private Date birthday;

    private String empPictureIndex;
}
