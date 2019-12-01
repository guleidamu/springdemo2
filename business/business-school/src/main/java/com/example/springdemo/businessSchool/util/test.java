package com.example.springdemo.businessSchool.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class test {

    public static void main(String arg[]){
        ExcelUtil excelUtil = new ExcelUtil();
        try {
            excelUtil.testExcel3();
            log.info("testExcel3结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
