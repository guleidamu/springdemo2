package com.example.springdemo.businessSchool.data.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClassVO implements Serializable {

    private Long classNo;

    private String className;

    private String masterName;

    private List<StudentVo> studentVoList;
}
