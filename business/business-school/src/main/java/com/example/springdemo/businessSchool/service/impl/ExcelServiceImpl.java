package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.util.ExcelDataUtil.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ExcelServiceImpl {

    private ExcelUtil excelUtil;

    public List readExcel(MultipartFile file, Integer nameRow, Integer valueRow) {

        List list = new ArrayList();

        try {
            list = excelUtil.readExcel(file, nameRow, valueRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
