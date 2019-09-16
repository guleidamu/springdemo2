package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.vo.Emp;
import com.example.springdemo.businessSchool.data.entity.Permission;
import com.example.springdemo.businessSchool.data.vo.SysUser;

import java.util.List;

public interface PermissionMapper {

    Emp getEmpById(Integer empId);

    SysUser getSysUserById(Integer sysUserId);

    int addSysUserPermission(List maplist);

    int deletePermission(Integer sysUserId);

    List<Permission> getPermissionBySysUserId(Integer sysUserId);
}
