package com.businessOracle.businessOracle.data.vo;

import com.example.springdemo.businessSchool.data.dict.SexType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentVo implements Serializable {

    private String studentNo;

    private String studentName;

//    private String studentSex;
    private SexType studentSex;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String studentBirthday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private String updateTime;

    private String classNo;

    private String studentSchoolClass;
}
