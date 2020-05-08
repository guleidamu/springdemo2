package com.thinkInJava.book.excel;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class testHSSF{

    public static void main(String[] args) {
        testHSSF testHSSFT = new testHSSF();
        try{
            testHSSFT.testHSSFMethod();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//    @Test
    public void testHSSFMethod() throws Exception{
//  创建一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        //  创建一个工作表
        HSSFSheet sheet = wb.createSheet();
//        wb.Worksheets.Clear();
//        Worksheet sheet = wk.Worksheets.Add("Sheet页名称");
//        Cells cell = sheet.Cells;
        // 设置单元格格式为文本格式
        HSSFCellStyle textStyle1 = wb.createCellStyle();
        HSSFDataFormat formatWB = wb.createDataFormat();
        textStyle1.setDataFormat(formatWB.getFormat("@"));

        //年月日时分秒格式
        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        HSSFDataFormat format = wb.createDataFormat();
        cellStyle2.setDataFormat(format.getFormat("yyyy/m/d hh:mm:ss"));

        //日期格式
        HSSFCellStyle cellStyle = wb.createCellStyle();
        HSSFDataFormat format1= wb.createDataFormat();
        cellStyle.setDataFormat(format1.getFormat("yyyy-MM-dd"));
//        cell.setCellStyle(cellStyle);

        //  创建字体
        HSSFFont font1 = wb.createFont();
        HSSFFont font2 = wb.createFont();
        font1.setFontHeightInPoints((short) 14);
        font1.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
        font2.setFontHeightInPoints((short) 12);
        font2.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        //  创建单元格样式
        HSSFCellStyle css1 = wb.createCellStyle();
        HSSFCellStyle css2 = wb.createCellStyle();
        HSSFCellStyle css3 = wb.createCellStyle();
        HSSFDataFormat df = wb.createDataFormat();
        //  设置单元格字体及格式
        css1.setFont(font1);
        css1.setDataFormat(df.getFormat("#,##0.0"));
        css2.setFont(font2);
        css2.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
        css3.setFont(font1);
        css3.setDataFormat(df.getFormat("#,##0.000"));

        //设置列的格式
        sheet.setDefaultColumnStyle(0, textStyle1);
        sheet.setDefaultColumnStyle(2, cellStyle2);
        sheet.setDefaultColumnStyle(3, cellStyle);
        sheet.setDefaultColumnStyle(4, css1);
        sheet.setDefaultColumnStyle(5, css3);
        //  创建行
        for (int i = 0; i < 1; i++) {
//            HSSFCell
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 10; j = j + 5) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue("55");
                cell.setCellStyle(textStyle1);
//                cell.setCellStyle(css1);
                HSSFCell cell2 = row.createCell(j+1);
                cell2.setCellValue(new HSSFRichTextString("66" + j));
//                cell2.setCellStyle(cellStyle);
                cell2.setCellStyle(textStyle1);

                HSSFCell cell3 = row.createCell(j+2);
                cell3.setCellValue(new HSSFRichTextString("20121201"));
                cell3.setCellStyle(textStyle1);

                HSSFCell cell5 = row.createCell(j+3);
                cell5.setCellValue(new HSSFRichTextString("2018/12/08"));
                cell5.setCellStyle(textStyle1);
            }
        }


        //创建列
//        for (int i = 0; i < 2; i++) {
            //设置单元格格式为"文本"

//            HSSFRow row = sheet.createRow(i);
//            for (int j = 0; j < 10; j = j + 5) {
//                HSSFCell cell = row.createCell(j);
//                cell.setCellValue("55");
//                cell.setCellStyle(cellStyle2);
////                cell.setCellStyle(css1);
//                HSSFCell cell2 = row.createCell(j+1);
//                cell2.setCellValue(new HSSFRichTextString("66" + j));
////                cell2.setCellStyle(cellStyle);
//                cell2.setCellStyle(css1);
//
//                HSSFCell cell3 = row.createCell(j+2);
//                cell3.setCellValue(new HSSFRichTextString("20121201"));
//                cell3.setCellStyle(cellStyle);
//
//                HSSFCell cell5 = row.createCell(j+3);
//                cell5.setCellValue(new HSSFRichTextString("2018/12/08"));
//                cell5.setCellStyle(css3);
//            }
//        }


        //  写文件
        FileOutputStream fos = new FileOutputStream("E:/workTest/wjcs2.xls");
        wb.write(fos);
        fos.close();
    }

    @Test
    public void testSS() throws IOException {
        Workbook[] wbs = {new HSSFWorkbook(), new XSSFWorkbook()};
        for (int i = 0; i < wbs.length; i++) {
            Workbook wb = wbs[i];
            CreationHelper creationHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet();
            for (int j = 0; j < 10; j++) {
                Row row = sheet.createRow(j);
                Cell cell = row.createCell(0);
                cell.setCellValue(creationHelper.createRichTextString("ABC"));
            }

            String filename = "F:/workbook.xls";
            if (wb instanceof XSSFWorkbook) {
                filename = filename + "x";
            }
            wb.write(new FileOutputStream(filename));
            wb.close();
        }
    }

}
