//package com.thinkInJava.book.excel;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExcelServiceImpl {
//
//    @Resource
//    private ExcelUtil excelUtil;
//
//    public List readExcel(MultipartFile file, Integer nameRow, Integer valueRow) {
//
//        List list = new ArrayList();
//
//        try {
//            list = excelUtil.readExcel(file, nameRow, valueRow);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//}
