package com.businessOracle.businessOracle.mapper;

import com.businessOracle.businessOracle.data.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<StudentVo> getStudentByName(@Param("name") String name);
}
