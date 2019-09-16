package com.businessOracle.businessOracle.service.StudentServiceImpl;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import com.businessOracle.businessOracle.mapper.StudentMapper;
import com.businessOracle.businessOracle.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<StudentVo> getStudentByName(SearchStudentDto searchStudentDto) {
        String name = searchStudentDto.getName();
        return studentMapper.getStudentByName(name);
    }
}
