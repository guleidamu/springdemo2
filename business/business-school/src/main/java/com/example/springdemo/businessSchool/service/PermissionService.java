package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.dto.PermissionDto;
import com.example.springdemo.businessSchool.data.dto.SearchPermissionDto;
import com.example.springdemo.businessSchool.data.vo.Emp;
import com.example.springdemo.businessSchool.data.vo.PermissionVo;
import com.example.springdemo.businessSchool.data.vo.SysUser;
import com.example.springdemo.businessSchool.response.Result;

import java.util.ArrayList;
import java.util.List;

public interface PermissionService {

    Emp getEmpById(Integer empId);

    SysUser getSysUserById(Integer sysUserId);

    int addSysUserPermission(PermissionDto permissionDto);

    ArrayList<PermissionVo> getPermissionBySysUserId(SearchPermissionDto searchPermissionDto);
}
