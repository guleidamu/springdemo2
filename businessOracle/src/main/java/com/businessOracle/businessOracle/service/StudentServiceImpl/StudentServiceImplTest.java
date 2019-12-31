package com.businessOracle.businessOracle.service.StudentServiceImpl;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.SchoolClassVo;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import com.businessOracle.businessOracle.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("studentServiceImplTest")
public class StudentServiceImplTest implements StudentService {
    @Override
    public ArrayList<StudentVo> getStudentByName(SearchStudentDto searchStudentDto) {
        StudentVo studentVo = new StudentVo();
        studentVo.setStudentName("kadaqia");
        studentVo.setStudentNo("you");
        ArrayList<StudentVo> list = new ArrayList<StudentVo>();
        list.add(studentVo);
        return list;
    }

    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Override
    public int insertStudentMethod(Student student) {
        return 0;
    }

    @Override
    public int insertStudentList(Student student) {
        return 0;
    }

    @Override
    public int insertStudentBatch(Student student) {
        return 0;
    }

    @Override
    public int insertStudentBatchNotSeq(Student student) {
        return 0;
    }

    @Override
    public int insertStudentBatchThreadAndNotSeq(Student student) {
        return 0;
    }

    @Override
    public int insertCourse(Course course) {
        return 0;
    }

    @Override
    public int sendMail() {
        return 0;
    }

    @Override
    public ArrayList<SchoolClassVo> querySchoolClassAndStudents(String teacherName) {
        return null;
    }
}
