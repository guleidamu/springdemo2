package com.businessOracle.businessOracle.controller;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import com.businessOracle.businessOracle.service.StudentService;
import com.businessOracle.businessOracle.service.StudentServiceImpl.StudentServiceImpl;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.github.pagehelper.PageInfo;
import com.example.springdemo.businessSchool.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/Oracle")
public class StudentController {

    @Resource
    private StudentService studentServiceImplTest;
    //StudentService studentService = new StudentService();报错，因为接口不能直接被实例化
//    StudentService studentService = new StudentServiceImpl();没报错，实现多态
    @Resource
    private StudentService studentServiceImpl;

    //同一个接口多个实现类，
    // 1可以通过在实现类使用@Service("XXX");来进行获取对应的实现类,private StudentService XXX(studentServiceImpl);
    //2通过@Resource(name = "XXX")来实现
    @Resource(name = "studentServiceImplTest")
    private StudentService studentServiceImplT;

    @ApiOperation(value = "通过学生名称获取学生信息", notes = "新增学生名称获取学生信息1")
    @PostMapping(value = "/getStudent")
    public Result getStudent(@Valid @RequestBody SearchStudentDto searchStudentDto) {
        return ResultBuilder.success(studentServiceImpl.getStudentByName(searchStudentDto));
    }

    @ApiOperation(value = "通过学生名称获取学生信息", notes = "新增学生名称获取学生信息1")
    @PostMapping(value = "/getStudentTest")
    public List<StudentVo> getStudentTest(@Valid @RequestBody SearchStudentDto searchStudentDto) {
        return studentServiceImplTest.getStudentByName(searchStudentDto);
    }


    @PostMapping(value = "/addStudent")
    public Result addStudent(@Valid @RequestBody Student student) {
        return ResultBuilder.success(studentServiceImpl.insertStudent(student));
    }

    @PostMapping(value = "/addStudentBatch")
    public Result addStudentBatch(@Valid @RequestBody Student student) {
        return ResultBuilder.success(studentServiceImpl.insertStudentList(student));
    }

    @PostMapping(value = "/addStudentBatchByBatch")
    public Result addStudentBatchByBatch(@Valid @RequestBody Student student) {
        return ResultBuilder.success(studentServiceImpl.insertStudentBatch(student));
    }

    @PostMapping(value = "/insertStudentMethod")
    public Result insertStudentMethod(@Valid @RequestBody Student student) {
        return ResultBuilder.success(studentServiceImpl.insertStudentMethod(student));
    }

    @PostMapping(value = "/addStudentBatchByBatchNotSeq")
    public Result addStudentBatchByBatchNotSeq(@Valid @RequestBody Student student) {
        return ResultBuilder.success(studentServiceImpl.insertStudentBatchNotSeq(student));
    }

    @PostMapping(value = "/updateStudent")
    public Result updateStudent(@Valid @RequestBody Student student) {
        return ResultBuilder.success(studentServiceImpl.insertStudent(student));
    }

    @PostMapping(value = "/getSchoolClassAndStudents")
    public Result getSchoolClassAndStudents(@RequestBody Map map){
        String teacherName = map.get("teacherName").toString();
        return ResultBuilder.success(studentServiceImpl.querySchoolClassAndStudents(teacherName));
    }

    @PostMapping(value = "/sendMail")
    public Result sendMail(@RequestBody Map map){
        return ResultBuilder.success(studentServiceImpl.sendMail());
    }
}
