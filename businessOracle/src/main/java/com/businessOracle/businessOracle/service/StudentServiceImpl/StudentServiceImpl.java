package com.businessOracle.businessOracle.service.StudentServiceImpl;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.SchoolClassVo;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import com.businessOracle.businessOracle.mapper.StudentMapper;
import com.businessOracle.businessOracle.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public ArrayList<StudentVo> getStudentByName(SearchStudentDto searchStudentDto) {
        String name = searchStudentDto.getName();
        return studentMapper.getStudentByName(name);
    }

    @Override
    public int insertStudent(Student student) {
        Date now = new Date();


        Date dd=new Date();
        //格式化
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sim.format(now);
        student.setStudentBirthday(now);
        student.setCreateTime(createTime);
        student.setUpdateTime(createTime);
        int i = studentMapper.insertStudent(student);
//        Student student1 = new Student();
//        student1.setStudentNo(student.getStudentNo()+1);
//        student1.setStudentSex(student.getStudentSex());
//        student1.setStudentName(student.getStudentName());
//
//        int k = studentMapper.insertStudent(student1);

//        Course course = new Course();
//        course.setCourseNo(student.getCourseNo());
//        course.setCourseName(student.getCourseName());
//        course.setTeacherNo(student.getTeacherNo());
//        insertCourse(course);
        return i;
    }

    @Override
    public int insertCourse(Course course) {
        int j = studentMapper.insertCourse(course);
        int m = 1/0;
        return j;
    }

    @Override
    public ArrayList<SchoolClassVo> querySchoolClassAndStudents(String teacherName) {
        return studentMapper.selectSchoolClass(teacherName);
    }

    public int insertCourseTo(Course course){
        return 0;
    }
}
