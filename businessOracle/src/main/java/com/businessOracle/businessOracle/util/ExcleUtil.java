package com.businessOracle.businessOracle.util;

import com.example.springdemo.businessSchool.ExcelDataUtil.Member;
import com.example.springdemo.businessSchool.data.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcleUtil {

    public HSSFWorkbook getHSSWorkbookTest(String sheetName, String taskId, String taskName, String[][] values, HSSFWorkbook wb) {
        //第一步，创建一个HSSFWorkbook，对应一个Excel文件
        wb = new HSSFWorkbook();
        //第二步，在workboo中添加一个sheet，对应Excel文件中的sheet（最下面的卡）
        HSSFSheet sheet = wb.createSheet(sheetName);
        //第三步，在sheet中添加表头第0行，第一行是从0开始的
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，并设置值表头，设置表头居中
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //设置格式
        HSSFDataFormat format = wb.createDataFormat();
        cellStyle.setDataFormat(format.getBuiltinFormat("#,##0.00"));//保留两位小数点
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        //声明列对象
        HSSFCell cell = null;

        String[] vehicles = {"员工车辆", "外协车辆", "货运车辆", "公司班车"};

        List<String> headerList = new ArrayList<String>();
        headerList.add("第一列");
        headerList.add("第二列");
        headerList.add(" 第三列");
        headerList.add("第四列");
        headerList.add("第五列");
        headerList.add("第六列");
        headerList.add("第七列");

        //日期格式
        HSSFDataFormat format2 = wb.createDataFormat();
//        style.setDataFormat(format.getFormat("yyyy-MM-dd"));

        // 设置单元格格式为文本格式
        HSSFCellStyle textStyle = wb.createCellStyle();
        HSSFCellStyle textStyle1 = wb.createCellStyle();
        HSSFCellStyle textStyle2 = wb.createCellStyle();
        HSSFDataFormat formatSheet = wb.createDataFormat();
        textStyle.setDataFormat(formatSheet.getFormat("@"));
        textStyle1.setDataFormat(formatSheet.getFormat("184"));
        textStyle2.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
        //设置单元格格式为"文本",从0开始计数的
        sheet.setDefaultColumnStyle(6, textStyle);
        sheet.setDefaultColumnStyle(8, textStyle1);
        sheet.setColumnWidth(7, 3766);
        sheet.setDefaultColumnStyle(9, textStyle2);
        //创建标题
        for (int i = 0; i < headerList.size(); i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(headerList.get(i));
//            cell.setCellStyle(cellStyle);
            log.info("表头" + i + ":");
        }
        Integer[][] IntegerValues = {{35, 55, 8}, {3, 66, 999}, {34, 634, 5345}};
        //创建内容
        for (int i = 0; i < IntegerValues.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < IntegerValues[i].length; j++) {
                //先将HSSFCell抽出来，设置.setCellStyle有效，否则无效row.createCell(j).setCellValue(date1);
                //将内容按顺序赋给对应的列对象
                HSSFCell cellDate = null;
                cellDate = row.createCell(j);
                cellDate.setCellStyle(cellStyle);
                cellDate.setCellValue(IntegerValues[i][j]);


            }
        }
        return wb;
    }

    public HSSFWorkbook getHSSWorkbook() {
//
//        private List<String> list=new ArrayList<String>();
//
//        cellmap.add("第一列");
//        cellmap.add("第二列");
//        cellmap.add(" 第三列");
//        cellmap.add("第四列");
//        cellmap.add("第五列");
//        cellmap.add( "第六列");
//        cellmap.add("第七列");


        return null;
    }

    /**
     * 导出excel模板
     *
     * @return
     * @throws ClassNotFoundException
     */
    public String ExcelOut(String path) throws Exception {
        //数据总行数
        int rows = 500;
        //生成下拉框内容
        String[] vehicles = {"员工车辆", "外协车辆", "货运车辆", "公司班车"};
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        org.apache.poi.hssf.usermodel.HSSFSheet sheet = workbook.createSheet("车辆信息录入");
        HSSFCellStyle style = workbook.createCellStyle(); // 样式对象
        style.setWrapText(true);//自动换行
        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
        //字体格式
        HSSFFont fonttitle1 = workbook.createFont();
        fonttitle1.setFontName("宋体");
        fonttitle1.setFontHeightInPoints((short) 10);
        style.setFont(fonttitle1);

        //excel模板
        int c = 0;
        HSSFRow row = sheet.createRow(0);//第一行

        //设置列宽  这里我只是把需要的两列设置了宽度   sheet.getColumnWidth(6)  获取第七列的宽度

        //网上查的可以自动设置列宽 但是不是我想要的模式，我做的是模板，导出后插入的数据列宽不会自动变，只好设置固定列宽

        //设置列宽
        sheet.setColumnWidth(6, sheet.getColumnWidth(6) * 17 / 13);
        sheet.setColumnWidth(9, sheet.getColumnWidth(9) * 18 / 5);

        /*sheet.autoSizeColumn(i); （版本不能太老）
        sheet.autoSizeColumn(i, true);（合并的单元格使用）
        sheet.setColumnWidth(i, “列名”.getBytes().length*2*256);（中文适用）
        公式单元格自适应的是公式，将值算出后再设置：
        HSSFFormulaEvaluator evaluator = new HSSFFormulaEvaluator(sheet.getWorkbook());
        CellValue cell71Val = evaluator.evaluate(cell71);
        cell71.setCellValue(cell71Val.getNumberValue());*/

        List<String> list = new ArrayList<String>();

        list.add("第一列");
        list.add("第二列");
        list.add(" 第三列");
        list.add("第四列");
        list.add("第五列");
        list.add("第六列");
        list.add("第七列");


        for (String s : list) {

            //把list中的值循环写入第一行
            HSSFCell cell = row.createCell(c); //第c列
            cell.setCellStyle(style);
            cell.setCellValue(s);
            c++;
        }
        //日期格式  这里我的模板内容从第二行开始，循环设置第6列的单元格为日期格式
        for (int a = 1; a <= rows; a++) {
            org.apache.poi.hssf.usermodel.HSSFCell cell = sheet.createRow(a).createCell(5);

            //日期格式
            HSSFDataFormat format = workbook.createDataFormat();
            style.setDataFormat(format.getFormat("yyyy-MM-dd"));
            cell.setCellStyle(style);
        }

        String specification = "hello\r\n   world";//     \r\n  换行
        // 合并单元格
        CellRangeAddress cra = new CellRangeAddress(2, 15, 12, 17); // 起始行, 终止行, 起始列, 终止列
        sheet.addMergedRegion(cra);

//        cell.setCellValue(specification);

        //显示结果为hello
        //生成下拉列表   起始行  列均从0开始
        CellRangeAddressList vehicle = new CellRangeAddressList(1, rows, 4, 4);//起始行,终止行,起始列，终止列
        // 创建下拉列表数据
        DVConstraint constraint_v = DVConstraint.createExplicitListConstraint(vehicles);
        // 绑定
        HSSFDataValidation dataValidation_v = new HSSFDataValidation(vehicle, constraint_v);
        //对sheet页生效
        sheet.addValidationData(dataValidation_v);

        //写入文件
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("E:\\aaaa.xls");//保存的文件路径
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(path);
        return path;
    }
}
