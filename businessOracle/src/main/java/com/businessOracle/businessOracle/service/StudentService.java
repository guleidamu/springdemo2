package com.businessOracle.businessOracle.service;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.vo.StudentVo;

import java.util.List;

public interface StudentService {

    List<StudentVo> getStudentByName(SearchStudentDto searchStudentDto);
}
