package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.dto.BusinessActInfDto;
import com.example.springdemo.businessSchool.data.dto.PermissionDto;
import com.example.springdemo.businessSchool.data.dto.SearchPermissionDto;
import com.example.springdemo.businessSchool.data.vo.Emp;
import com.example.springdemo.businessSchool.data.entity.Permission;
import com.example.springdemo.businessSchool.data.vo.PermissionVo;
import com.example.springdemo.businessSchool.data.vo.SysUser;
import com.example.springdemo.businessSchool.mapper.PermissionMapper;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public Emp getEmpById(Integer empId) {
        return permissionMapper.getEmpById(empId);
    }

    @Override
    public SysUser getSysUserById(Integer sysUserId) {
        return permissionMapper.getSysUserById(sysUserId);
    }

    @Transactional
    @Override
    public int addSysUserPermission(PermissionDto permissionDto) {

        List<Map<String, Object>> maplist = new ArrayList<>();
        Integer sysUserId = permissionDto.getSysUserId();
        Map<Integer, Object> map = new HashMap<>();
        List<BusinessActInfDto> businessActInfDtos = permissionDto.getBusinessActInfDtos();
        int flag = permissionMapper.deletePermission(sysUserId);
        for (BusinessActInfDto businessActInfDto : businessActInfDtos) {
            String business = businessActInfDto.getBusiness();
            String[] actInfIds = businessActInfDto.getActInfList();
            for (String actInfId : actInfIds) {
                Map<String, Object> maps = new HashMap<>();
                maps.put("sysUserId", sysUserId);
                maps.put("business", business);
                maps.put("actInfId", actInfId);
                maplist.add(maps);
            }
        }
        return permissionMapper.addSysUserPermission(maplist);
    }

    @Override
    public ArrayList<PermissionVo> getPermissionBySysUserId(SearchPermissionDto searchPermissionDto) {
        Integer sysUserId = searchPermissionDto.getSysUserId();
        List<Permission> permissionList = permissionMapper.getPermissionBySysUserId(searchPermissionDto.getSysUserId());
        Map<Integer, Object> businessIdMap = new HashMap<>();
        List<String> businessNameList = new ArrayList<>();
        for (Permission permission : permissionList) {
            if(!businessIdMap.containsKey(permission.getBusiness())){
                businessIdMap.put(permission.getBusiness(),permission.getBusiness());
            }
            if (!businessNameList.contains(permission.getBusinessName())) {
                businessNameList.add(permission.getBusinessName());
            }
        }

        ArrayList<PermissionVo> permissionVoList = new ArrayList<>();
        for(String businessName: businessNameList){
            PermissionVo permissionVo = new PermissionVo();
            permissionVo.setBusinessName(businessName);
            List<String> actCdList = new ArrayList<>();
            List<String> actNmList = new ArrayList<>();
            for(Permission permission : permissionList){
                if(businessName.equals(permission.getBusinessName())){
                    actCdList.add(permission.getActCd());
                    actNmList.add(permission.getActNm());
                }
            }
            permissionVo.setActCd(actCdList);
            permissionVo.setActName(actNmList);
            permissionVoList.add(permissionVo);
         }
        return permissionVoList;
    }
}
