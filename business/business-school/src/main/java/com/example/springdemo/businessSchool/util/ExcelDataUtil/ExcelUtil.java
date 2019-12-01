package com.example.springdemo.businessSchool.util.ExcelDataUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
@Slf4j
public class ExcelUtil {


    public static List<Map<String, Object>> readExcel(MultipartFile file, int nameRow, int valueRow) throws IOException {
        List<Map<String,Object>> Row = new ArrayList<Map<String,Object>>();
        try{
            Workbook workbook = null;
            InputStream io = file.getInputStream();
            try {
                workbook = new HSSFWorkbook(io);
            } catch (IOException e) {
                workbook = new XSSFWorkbook(io);
            }
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++ ){
                Sheet sheet = workbook.getSheetAt(numSheet);
                log.info("sheet:" + ((Sheet) sheet).getSheetName() + "!!!" + sheet.getCellComments());
                if (null == sheet){
                    continue;
                }
                org.apache.poi.ss.usermodel.Row row0 = sheet.getRow(nameRow);
                if(null == row0){
                    continue;
                }
                int colum = row0.getPhysicalNumberOfCells();
                ArrayList<String> keys = new ArrayList<String>();
                for(int i = 0; i<colum; i++){
                    Cell cell = row0.getCell(i);
                    log.info("row0.getCell:" + i + cell.toString());
                    keys.add(cell.toString());
                }
                //循环行
                for(int rowNum = valueRow; rowNum <= sheet.getPhysicalNumberOfRows(); rowNum++){
                    //是否到达文件末尾
                    boolean isEnd = true;
                    Row row = sheet.getRow(rowNum);
                    if(null == row){
                        continue;
                    }

                    //循环列cell
                    Map<String, Object> arrCell = new HashMap<String, Object>();
                    for (int cellNum = 0; cellNum< colum; cellNum++){
                        Cell cell = row.getCell(cellNum);
                        if(cell == null){
                            arrCell.put(keys.get(cellNum)," ");
                        } else{
                            arrCell.put(keys.get(cellNum), getValue(cell,workbook));
                        }
                    }

                    Row.add(arrCell);
                }
            }
        }catch(IOException e){
            System.out.println("e:"+e);
            throw e;
        }
        return Row;
    }

    private static String getValue(Cell cell, Workbook workbook){
        String result = new String();
        switch (cell.getCellType()){

            case NUMERIC: //字段类型
                log.info("数字类型" + cell.getCellStyle().getDataFormat());
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat sdf = null;
                    if(cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")){
                        sdf = new SimpleDateFormat("HH:mm");
                    }else {//日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                }else if(cell.getCellStyle().getDataFormat() == 181){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    double value = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                    result = sdf.format(date);
                }else if(cell.getCellStyle().getDataFormat() == 58 ){
                    //处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                    result = sdf.format(date);
                }else {
                    double value = cell.getNumericCellValue();
                    CellStyle style = cell.getCellStyle();
                    NumberFormat nf = NumberFormat.getInstance();
                    String s = nf.format(value);
                    if(s.indexOf(",") >=0 ){
                        s = s.replace(",","");
                    }
                    result = value +"";
                    result = s;
                }
                break;
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case FORMULA:
                result = cell.getNumericCellValue() + "";
                break;
            case BLANK:
                result = "";
            default:
                result ="";
                break;
        }
        return result;
    }
}
