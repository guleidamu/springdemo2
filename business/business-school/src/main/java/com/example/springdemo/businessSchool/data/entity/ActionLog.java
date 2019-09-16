package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ActionLog {

    private String logId;

    private String actionContent;

    private String actionStaff;

    private Date actionTime;

    private String actionIp;
}
