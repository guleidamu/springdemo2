package com.example.springdemo.businessSchool.util;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//这个可以作为一个导出的小小例子
public class ExcelTest {

    public static void main(String arg[]){
        //创建工作薄对象
        HSSFWorkbook workbook=new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();
        //创建工作表的行
        HSSFRow row = sheet.createRow(0);//设置第一行，从零开始
        row.createCell(2).setCellValue("aaaaaaaaaaaa");//第一行第三列为aaaaaaaaaaaa
        row.createCell(0).setCellValue("美丽的草原，我的家");//第一行第三列为aaaaaaaaaaaa
//        row.createCell(0).setCellValue(new Date());//第一行第一列为日期
        workbook.setSheetName(0,"sheet的Name");//设置sheet的Name


        //创建文档信息
        workbook.createInformationProperties();
        //获取DocumentSummaryInformation对象
        DocumentSummaryInformation documentSummaryInformation = workbook.getDocumentSummaryInformation();
        documentSummaryInformation.setCategory("类别:Excel文件");//类别
        documentSummaryInformation.setManager("管理者:王军");//管理者
        documentSummaryInformation.setCompany("公司:Action");//公司


        try {
            //文档输出
            FileOutputStream out = new FileOutputStream("e:/potest1.xls" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xls");
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
