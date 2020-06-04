package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.dto.ClassDTO;
import com.example.springdemo.businessSchool.data.entity.ClassModel;
import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.data.vo.ClassVO;
import com.example.springdemo.businessSchool.mapper.ClassMapper;
import com.example.springdemo.businessSchool.mapper.StudentMapper;
import com.example.springdemo.businessSchool.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public ArrayList<ClassVO> queryClassByMasterName(ClassDTO classDTO) {
        return classMapper.getClassByMasterName(classDTO);
    }

    @Override
    public void addClassList() {
        List<ClassModel> classModelList = new ArrayList<>();
        List<Student> studentList1 = new ArrayList<>();
        List<Student> studentList2 = new ArrayList<>();
        ClassModel class1 = new ClassModel();
        class1.setClassName("高二5班");
        class1.setMasterName("陈道明");
        Student student1 = new Student();
        student1.setStudentName("令狐冲");
        student1.setStudentSex("1");
        student1.setClassNo("67");
        student1.setCourseNo("56");
        Student student2 = new Student();
        student2.setStudentName("任盈盈");
        student2.setStudentSex("0");
        student2.setClassNo("67");
        student2.setCourseNo("56");
        studentList1.add(student1);
        studentList1.add(student2);

        ClassModel class2 = new ClassModel();
        class2.setClassName("高二6班");
        class2.setMasterName("陈宝国");
        Student student3 = new Student();
        student3.setStudentName("欧阳锋");
        student3.setStudentSex("1");
        student3.setClassNo("68");
        student3.setCourseNo("88");
        Student student5 = new Student();
        student5.setStudentName("洪七公");
        student5.setStudentSex("1");
        student5.setClassNo("68");
        student5.setCourseNo("88");
        studentList2.add(student3);
        studentList2.add(student5);

        class1.setStudentList(studentList1);
        class2.setStudentList(studentList2);

        classModelList.add(class1);
        classModelList.add(class2);

        classMapper.insertClassBatch(classModelList);
        classModelList.forEach(o ->{
            System.out.println(o.getClassNo());
            o.getStudentList().forEach(p ->{
                p.setClassNo(o.getClassNo().toString());
            });
//            o.getClassNo()
//            o.getStudent().setClassNo(o.getClassNo().toString());
        });
        System.out.println(classModelList.toString());
        List<Student> studentList8 = classModelList.stream().map(ClassModel::getStudent).collect(Collectors.toList());
        Stream stream = classModelList.stream();
        System.out.println("classModelList.stream();>>" + stream);
        Stream stream1 = classModelList.stream().map(ClassModel::getStudent);
        System.out.println("stream1" + stream1);
        System.out.println("classModelList.stream().map(ClassModel::getStudent)"+classModelList.stream().map(ClassModel::getStudent));
        System.out.println(studentList8);
//        studentMapper.insertStudentBatch(studentList8);
    }
}
