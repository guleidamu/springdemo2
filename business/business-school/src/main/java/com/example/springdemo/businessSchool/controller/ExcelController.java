package com.example.springdemo.businessSchool.controller;
import com.example.springdemo.businessSchool.ExcelDataUtil.Member;
import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.response.ResultBuilder;
//import com.thinkInJava.book.excel.model.Student;
import com.example.springdemo.businessSchool.service.impl.ExcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.util.StringUtil;
import org.springframework.web.bind.annotation.*;
import com.example.springdemo.businessSchool.response.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/common")
public class ExcelController {

    @Resource
    private ExcelServiceImpl excelService;
    @PostMapping(value = "/addExcel")
    public Result addExcelDatas(ServletRequest request, @RequestParam("file") MultipartFile file, String param){
        Long fileByte = file.getSize();
        List list = new ArrayList();
        list = excelService.readExcel(file,0,1);
        Result result = new Result();
        result.setData(list);

        String filename = "copy" + file.getOriginalFilename();
        String filePath = "E:\\";
        File dest = new File(filePath + filename);
        try {
            file.transferTo(dest);
            log.info("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


//    @PostMapping(value= "/addExcel")
//    public Result getFile(MultipartFile file, String id){
//        List list = new ArrayList();
//        return ResultBuilder.success();
//    }

    @PostMapping(value = "/exportExcel")
    public void exportExcel(@RequestBody Map map, HttpServletResponse response) throws IOException{
        String taskId = (String)map.get("taskId");
        String sheetName = (String)map.get("sheetName");
        String taskName = "taskName";
        if(null != taskId)
        {}
        String[][] values = null;
        HSSFWorkbook wb = null;
        if("".equals(sheetName) || sheetName ==null){
//            return
        }
        HSSFWorkbook workbook = this.getHSSWorkbookTest(sheetName, taskId, taskName, values, wb);
        OutputStream outputStream ;
        OutputStream oot;
        outputStream = response.getOutputStream();
        OutputStream os = response.getOutputStream();
        log.info("\"Content-Disposition\"","\"attachment; filename=" +taskName +".xls\"");
        try {
            response.reset();
            String headkey = "\"Content-Disposition\"";
            String headvalue = "\"attachment; filename=" + taskName + ".xls\"";
            System.out.println("headKey:" + headkey);
            System.out.println("headvalue" + headvalue);
            response.setHeader("Content-Disposition", "attachment; filename=" + taskName + ".xls");
            String name = response.getHeader("Content-Disposition");
            log.info("name: "+ name);
            response.setContentType("application/octet-stream; charset=utf-8");
            workbook.write(response.getOutputStream());
            os.flush();
        } finally {
            if(os!=null){
                os.close();
            }
        }
    }

//    public HSSFWorkbook getHSSWorkbook(String sheetName, String taskId, String taskName, String[][] values, HSSFWorkbook wb){
//        //第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if(wb == null){
//            wb = new HSSFWorkbook();
//        }
//        //第二步，在workboo中添加一个sheet，对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet(sheetName);
//        //第三步，在sheet中添加表头第0行，注意老版本poi对excel的行数列数有限制
//        HSSFRow row = sheet.createRow(0);
//        //第四步，创建单元格，并设置值表头，设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        //style
//
//        HSSFCellStyle cellStyle = wb.createCellStyle();
//
//        HSSFDataFormat format= wb.createDataFormat();
//
//        cellStyle.setDataFormat(format.getFormat("0.00"));
////
////        cell.setCellStyle(cellStyle);
//        //
//        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
//        //声明列对象
//        HSSFCell cell = null;
//        //创建标题
//        //查询
//        List<Student> list = new ArrayList();
//        Student student1 = new Student();
//        student1.setStudentNo(66);
//        student1.setStudentName("5");
//        student1.setStudentSex("2");
//        list.add(student1);
//        Student student2 = new Student();
//        student2.setStudentNo(88);
//        student2.setStudentName("5");
//        student2.setStudentSex("1");
//        list.add(student2);
//
//        for(int i = 0; i<list.size(); i++){
//            cell = row.createCell(i);
//            cell.setCellValue((list.get(i)).getStudentName());
//            cell.setCellStyle(style);
////            cell.setCellStyle(cellStyle);
//            log.info("表头" + i +":" + list.get(i).getStudentName());
//        }
////        for(int i =0;i<title.length;i++){
////            cell = row.createCell(i);
////            cell.setCellValue(title[i]);
////            cell.setCellStyle(style);
////        }
//        List<Member> listTest = new ArrayList<Member>();
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//
//
//        try {
//            Member user1 = new Member(1, "熊大", 24, df.parse("1993-08-28"));
//            Member user2 = new Member(2, "熊二", 23, df.parse("1994-08-19"));
//            Member user3 = new Member(3, "熊熊", 24, df.parse("1983-11-22"));
//
//            listTest.add(user1);
//            listTest.add(user2);
//            listTest.add(user3);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        String[][] valuesTest = {{"q","4","p"},{"q2","8","p2"},{"q","4","p"}};
//
//        //创建内容
//        for(int i = 0; i<valuesTest.length; i++){
//            row = sheet.createRow(i+1);
//            for(int j = 0; j<valuesTest[i].length; j++){
//                //将内容按顺序赋给对应的列对象
//                row.createCell(j).setCellValue(valuesTest[i][j]);
//            }
//        }
//        return wb;
//    }

    public HSSFWorkbook getHSSWorkbookTest(String sheetName, String taskId, String taskName, String[][] values, HSSFWorkbook wb){
        //第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }
        //第二步，在workboo中添加一个sheet，对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        //第三步，在sheet中添加表头第0行，注意老版本poi对excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);
        HSSFRow row7 = sheet.createRow(7);
        //第四步，创建单元格，并设置值表头，设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        //style

        HSSFCellStyle cellStyle = wb.createCellStyle();

        HSSFDataFormat format= wb.createDataFormat();

        cellStyle.setDataFormat(format.getBuiltinFormat("#,##0.00"));//保留两位小数点

        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        //声明列对象
        HSSFCell cell = null;
        HSSFCell cell_11 = null;
        //创建标题
        //查询
        List<Student> list = new ArrayList();
        Student student1 = new Student();
        student1.setStudentNo(66);
        student1.setStudentName("5");
        student1.setStudentSex("2");
        list.add(student1);
        Student student2 = new Student();
        student2.setStudentNo(88);
        student2.setStudentName("5");
        student2.setStudentSex("1");
        list.add(student2);

        for(int i = 0; i<list.size(); i++){
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue((list.get(i)).getStudentNo());
//            cell.setCellStyle(cellStyle);

            log.info("表头" + i +":" + list.get(i).getStudentNo());
        }
        Integer five = 5;
        for(int i =5;i<10;i++){
            cell = row7.createCell(i);
            cell.setCellValue(i);
            cell.setCellStyle(cellStyle);
            cell_11 = row7.createCell(11);
            cell_11.setCellValue(five);
            cell_11.setCellStyle(cellStyle);
        }
        List<Member> listTest = new ArrayList<Member>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");


        try {
            Member user1 = new Member(1, "熊大", 24, df.parse("1993-08-28"));
            Member user2 = new Member(2, "熊二", 23, df.parse("1994-08-19"));
            Member user3 = new Member(3, "熊熊", 24, df.parse("1983-11-22"));

            listTest.add(user1);
            listTest.add(user2);
            listTest.add(user3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[][] valuesTest = {{"q","4","p"},{"q2","8","5"},{"q","4","p"}};
        Float[][] intValuesTest = {{3.43F,5.53F,8F},{3F,66F,999F},{34F,634F,5345F}};
        int[][] intValues = {{3,5,8},{3,66,999},{34,634,5345}};
        Integer[][] IntegerValues = {{35,55,8},{3,66,999},{34,634,5345}};
        Integer date1 = 83;

        //创建内容
        for(int i = 0; i<IntegerValues.length; i++){
            row = sheet.createRow(i+1);
            for(int j = 0; j<IntegerValues[i].length; j++){
                //将内容按顺序赋给对应的列对象
                //先将HSSFCell抽出来，设置.setCellStyle有效，否则无效row.createCell(j).setCellValue(date1);
                HSSFCell cellDate = null;
                cellDate = row.createCell(j);
                cellDate.setCellStyle(cellStyle);
                cellDate.setCellValue(IntegerValues[i][j]);

                cellDate = row.createCell(j+15);
                cellDate.setCellStyle(cellStyle);
                cellDate.setCellValue(date1);

                (row.createCell(j+5)).setCellStyle(cellStyle);
                (row.createCell(j+5)).setCellValue(date1);


                row.createCell(j+10).setCellStyle(cellStyle);
                row.createCell(j+10).setCellValue(date1);

            }
        }
        return wb;
    }

    @PostMapping(value = "/addDataInExcel")
    public void addData(){
        String url = "E:/copyresponse1117.xls";
        FileInputStream fs;
        try {
            fs = new FileInputStream(url);
            POIFSFileSystem ps = new POIFSFileSystem(fs);
            HSSFWorkbook wb = new HSSFWorkbook(ps);
            HSSFSheet sheet = wb.getSheetAt(0);//获取到工作表，因为excel可能有多个工作表
            HSSFRow row = sheet.getRow(0);
            HSSFCell cell = row.createCell((short)2);
            int hang = 0;
            int lie = 0;
            if("".equals(row)||row ==null){
                hang = 0;
            }else{
                hang = sheet.getLastRowNum();
                hang = hang +1;
            }

//            if("".equals(sheet)||row ==null){
//                lie = 0;
//            }else{
//                lie = row.getLastCellNum();
//                lie = lie + 1;
//            }
            //分别得到最后一行的行号，和一条记录的最后一个单元格
            FileOutputStream out = new FileOutputStream(url);// 向d:/
            row = sheet.createRow((short)(hang));
            row.createCell(0).setCellValue("安徽");
            row.createCell(1).setCellValue("安庆");
            //
//            sheet = row.
            HSSFRow row3 = sheet.getRow(3);
//            HSSFRow row1 = sheet.createRow(1);
//            row1.createCell(3).setCellValue("襄阳");
//            row1.createCell(4).setCellValue("贵阳");
            row3.createCell(3).setCellValue("襄阳3");
            row3.createCell(4).setCellValue("贵阳3");

            out.flush();
            wb.write(out);
            out.close();
            System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/downloadExcel")
    public void downloadExcel(@RequestBody Map map, HttpServletResponse response) throws Exception{

        String excelName =(String)map.get("excelName");
        HSSFWorkbook wb = null;
        String filePath = "E:/copyresponse1117.xls";
        OutputStream out = null;
        FileInputStream inputStream = new FileInputStream(filePath);
        int i = inputStream.available();
        byte[] buff = new byte[i];
        inputStream.read(buff);
        inputStream.close();
//        response.setContentType();
        OutputStream out1 = response.getOutputStream();
        out1.write(buff);
//        try{
//        }
        OutputStream os = response.getOutputStream();
        log.info("\"Content-Disposition\"","\"attachment; filename=" +excelName +".xls\"");
//        try {
//            response.reset();
//            String headkey = "\"Content-Disposition\"";
//            String headvalue = "\"attachment; filename=" + excelName + ".xls\"";
//            System.out.println("headKey:" + headkey);
//            System.out.println("headvalue" + headvalue);
//            response.setHeader("Content-Disposition", "attachment; filename=" + excelName + ".xls");
//            String name = response.getHeader("Content-Disposition");
//            log.info("name: "+ name);
//            response.setContentType("application/octet-stream; charset=utf-8");
////            workbook.write(response.getOutputStream());
//            os.flush();
//        } finally {
//            if(os!=null){
//                os.close();
//            }
//        }
    }

    public void addRoad(){
        File file = new File("d:\\test");
        if(file.exists()){

        }
    }

}
