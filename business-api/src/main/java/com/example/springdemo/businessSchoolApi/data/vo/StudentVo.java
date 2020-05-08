package com.example.springdemo.businessSchoolApi.data.vo;

import com.example.springdemo.businessSchoolApi.data.dict.SexType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentVo implements Serializable {

    private Integer sno;

    private String sname;

    private SexType ssex;

    private Date sbirthday;

    private String calssno;
}
