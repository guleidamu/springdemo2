package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.dto.ClassDTO;
import com.example.springdemo.businessSchool.data.vo.ClassVO;

import java.util.ArrayList;
import java.util.List;

public interface ClassService {

    ArrayList<ClassVO> queryClassByMasterName(ClassDTO classDTO);

    void addClassList();
}
