package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.dto.ClassDTO;
import com.example.springdemo.businessSchool.data.entity.ClassModel;
import com.example.springdemo.businessSchool.data.vo.ClassVO;

import java.util.ArrayList;
import java.util.List;

public interface ClassMapper {

    ArrayList<ClassVO> getClassByMasterName(ClassDTO classDTO);

    void insertClassBatch(List<ClassModel> classModelList);
}
