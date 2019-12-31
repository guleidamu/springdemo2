package com.businessOracle.businessOracle.controller;

import com.businessOracle.businessOracle.util.ExcleUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

@Slf4j
@Api(description = "excel")
@RestController
@RequestMapping(value = "/Excel")
public class ExcelController {

    ExcleUtil excleUtil = new ExcleUtil();

    @PostMapping(value = "/exportDemo")
    public void export(@RequestBody Map map, HttpServletResponse response) throws Exception{
        String sheetName = (String)map.get("sheetName");
        String taskName = "taskName";
        String taskId = "";
        String[][] values = null;
        HSSFWorkbook wb = null;
        HSSFWorkbook workbook = excleUtil.getHSSWorkbookTest(sheetName, taskId, taskName, values, wb);
        OutputStream os = response.getOutputStream();
        log.info("\"Content-Disposition\"","\"attachment; filename=" +taskName +".xls\"");
        try {
            response.reset();
            String headkey = "\"Content-Disposition\"";
            String headvalue = "\"attachment; filename=" + taskName + ".xls\"";
            log.info("headKey:" + headkey);
            log.info("headvalue" + headvalue);
            response.setHeader("Content-Disposition", "attachment; filename=" + taskName + ".xls");
            String name = response.getHeader("Content-Disposition");
            log.info("Dname:"+ name);
            response.setContentType("application/octet-stream; charset=utf-8");
            workbook.write(response.getOutputStream());
            //xz
            //
            os.flush();
        } finally {
            if(os!=null){
                os.close();
            }
        }
    }

    @PostMapping(value = "/ExcelOut")
    public void ExcelOut(){
        String path = "E://";
        try {
            excleUtil.ExcelOut(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
