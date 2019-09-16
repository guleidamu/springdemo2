package com.example.springdemo.businessSchool.data.dto;

import lombok.Data;

import java.util.List;

@Data
public class PermissionDto {

    private Integer empId;

    private Integer sysUserId;

    private List<BusinessActInfDto> businessActInfDtos;
}
