package com.businessOracle.businessOracle.data.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentVo {

    private String studentNo;

    private String studentName;

    private String studentSex;

    private Date studentBirthday;

    private String classNo;
}
