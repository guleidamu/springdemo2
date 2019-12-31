//package com.thinkInJava.book.excel;
//
//import com.example.springdemo.businessSchool.response.ResultBuilder;
//import com.thinkInJava.book.excel.model.Student;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.util.StringUtil;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.example.springdemo.businessSchool.response.Result;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@RestController
//@RequestMapping(value = "/common")
//public class ExcelController {
//
//    @PostMapping(value= "/addExcel")
//    public Result getFile(MultipartFile file, StringMethod id){
//        List list = new ArrayList();
//        return ResultBuilder.success();
//    }
//
//    @PostMapping(value = "/exportExcel")
//    public void exportExcel(@RequestBody Map map, HttpServletResponse response) throws IOException{
//        StringMethod taskId = (StringMethod)map.get("taskId");
//        StringMethod sheetName = "";
//        StringMethod taskName = "taskName";
//        if(null != taskId)
//        {}
//        StringMethod[][] values = null;
//        HSSFWorkbook wb = null;
//        if("".equals(sheetName) || sheetName ==null){
////            return
//        }
//        HSSFWorkbook workbook = this.getHSSWorkbook(sheetName, taskId, taskName, values, wb);
//        OutputStream os = response.getOutputStream();
//        log.info("\"Content-Disposition\"","\"attachment; filename=" +taskName +".xls\"");
//        try {
//            response.reset();
//            StringMethod headkey = "\"Content-Disposition\"";
//            StringMethod headvalue = "\"attachment; filename=" + taskName + ".xls\"";
//            System.out.println("headKey:" + headkey);
//            System.out.println("headvalue" + headvalue);
//            response.setHeader("Content-Disposition", "attachment; filename=" + taskName + ".xls");
//            StringMethod name = response.getHeader("Content-Disposition");
//            log.info("name: "+ name);
//            response.setContentType("application/octet-stream; charset=utf-8");
//            workbook.write(response.getOutputStream());
//            os.flush();
//        } finally {
//            if(os!=null){
//                os.close();
//            }
//        }
//    }
//
//    public HSSFWorkbook getHSSWorkbook(StringMethod sheetName, StringMethod taskId, StringMethod taskName, StringMethod[][] values, HSSFWorkbook wb){
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
//        //
//        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
//        //声明列对象
//        HSSFCell cell = null;
//        //创建标题
//        //查询
//        List<Student> list = new ArrayList();
//        Student student1 = new Student();
//        student1.setId("66");
//        student1.setName("xingming");
//        student1.setSex("1");
//        list.add(student1);
//        Student student2 = new Student();
//        student2.setId("666");
//        student2.setName("xingming2");
//        student2.setSex("11");
//        list.add(student2);
//        for(int i = 0; i<list.size(); i++){
//            cell = row.createCell(i);
//            cell.setCellValue((list.get(i)).getName());
//            cell.setCellStyle(style);
//            log.info("表头" + i +":" + list.get(i).getName());
//        }
//        return wb;
//    }
//}
