package com.example.springdemo.businessSchool.data.dto;

import com.example.springdemo.businessSchool.data.vo.ActInf;
import lombok.Data;

import java.util.List;

@Data
public class BusinessActInfDto {

    private String business;

    private String[] actInfList;
}
