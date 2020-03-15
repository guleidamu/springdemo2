package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.data.dict.LogRecord;
import com.example.springdemo.businessSchool.data.dto.DynamicDto;
import com.example.springdemo.businessSchool.data.dto.SearchStudentSearchDto;
import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;

@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/student")
@EnableCaching
public class StudentController {

    @Resource
    private StudentService studentService;

    @Value("${file.upload}")
    private String filePath;

    @Value("${file.upload}")
    private String downLoadFilePath;

//   private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @LogRecord
    @ApiOperation(value = "通过学生名称获取学生信息", notes = "新增学生名称获取学生信息1")
    @PostMapping(value = "/getStudent")
    public Result<PageInfo<StudentVo>> getStudent(@Valid @RequestBody SearchStudentSearchDto searchStudentDto) {
        PageInfo<StudentVo> result = studentService.findStudentByName(searchStudentDto);
        return ResultBuilder.success(result);
    }

    @PostMapping(value="/getDynamicStudent")
    public Result getDynamicStudent(@RequestBody DynamicDto dynamicDto){
        Result result = new Result();
        result.setData(studentService.getDynamicStudent(dynamicDto));
        return result;
    }

    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartFile file){

        return ResultBuilder.error("500","上传失败");
    }


    @PostMapping("/addUser")
    public Result addUser(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return ResultBuilder.error("500","上传失败，请重新选择");
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(filePath+fileName);
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return ResultBuilder.success("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultBuilder.error("500","上传失败");
    }


    @RequestMapping("/downloadFile")
    public void download(HttpServletResponse response) throws Exception{
     String downloadFilePath = downLoadFilePath;
     String fileName = "test";

//     File file = new File(downloadFilePath);
//     if(file.exists()){
//         response.setContentTy
//     }
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PostMapping("/getStudentByRedis")
    public Result getStudentByRedis(@RequestBody SearchStudentSearchDto searchStudentDto){
        return ResultBuilder.success(studentService.getStudentByRedis(searchStudentDto));
    }

}
