package com.example.springdemo.businessSchool.data.vo;

import lombok.Data;

import java.util.List;

@Data
public class PermissionVo {

//    private Integer business;

    private String businessName;
//    private List<String> actCd;
//
//    private List<String> actNm;
//    private List<Integer> actInfId;

    private List<String> actName;

    private List<String> actCd;
}
