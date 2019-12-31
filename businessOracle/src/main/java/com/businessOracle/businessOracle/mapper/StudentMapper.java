package com.businessOracle.businessOracle.mapper;

import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.SchoolClassVo;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudentMapper {
    ArrayList<StudentVo> getStudentByName(@Param("name") String name);

    int insertStudent(Student student);

    int insertCourse(Course course);

    int studentSeq();

    int insertStudentBatch(List<Student> list);

    int insertStudentBatchNotSeq(List<Student> list);

    ArrayList<SchoolClassVo> selectSchoolClass(@Param("teacherName") String teacherName);
}
