package com.businessOracle.businessOracle.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {

    private String deptNo;

    private String dName;

    private String loc;
}
