package com.businessOracle.businessOracle.data.vo;

import com.businessOracle.businessOracle.data.entity.Student;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SchoolClassVo implements Serializable {

    private Integer classNo;

    private String className;

    private String address;

    private String teacherName;

    private List<StudentVo> studentList;
}
