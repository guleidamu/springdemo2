package com.example.springdemo.businessSchool.service.utils;

import javax.servlet.http.HttpServletRequest;

public class SkillsUtils {

    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        return ip;
    }
}
