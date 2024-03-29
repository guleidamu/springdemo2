package com.example.springdemo.businessSchool.util;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;


public class PoiExcel {

    /**
     * POI生成Excel文件
     * @author David
     * @param args
     */
    public static void main(String[] args) {

        String[] title = {"id","name","sex"};

        //创建Excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个工作表sheet
        Sheet sheet = workbook.createSheet();
        //创建第一行
        Row row = sheet.createRow(0);
        Cell cell = null;
        //插入第一行数据 id,name,sex
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加数据
        for (int i = 1; i <= 10; i++) {
            Row nextrow = sheet.createRow(i);
            Cell cell2 = nextrow.createCell(0);
            cell2.setCellValue("a" + i);
            cell2 = nextrow.createCell(1);
            cell2.setCellValue("user" + i);
            cell2 = nextrow.createCell(2);
            cell2.setCellValue("男");
        }
        //创建一个文件
        File file = new File("e:/poi_test.xls");
        try {
            file.createNewFile();
            //将Excel内容存盘
//            FileOutputStream stream = FileUtils.openOutputStream(file);
//            workbook.write(stream);
//            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
