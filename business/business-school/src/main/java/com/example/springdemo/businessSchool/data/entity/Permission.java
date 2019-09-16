package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

@Data
public class Permission {

    private Integer sysUserId;

    private Integer actInfId;

    private Integer business;

    private String actCd;

    private String actNm;

    private String businessName;
}
