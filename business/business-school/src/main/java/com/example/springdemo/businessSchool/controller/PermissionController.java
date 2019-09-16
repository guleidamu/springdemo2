package com.example.springdemo.businessSchool.controller;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.businessSchool.data.dto.PermissionDto;
import com.example.springdemo.businessSchool.data.dto.SearchPermissionDto;
import com.example.springdemo.businessSchool.data.vo.Emp;
import com.example.springdemo.businessSchool.data.vo.PermissionVo;
import com.example.springdemo.businessSchool.data.vo.SysUser;
import com.example.springdemo.businessSchool.response.ResponseVo;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

@Api(description = "权限")
@RestController
@RequestMapping("/Permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @PostMapping("/setUserPermission")
    @ApiOperation(value = "用户权限设置")
    public ResponseVo<Object> setPermission(@RequestBody PermissionDto permissionDto) {
        ResponseVo responseVo = new ResponseVo();
        Integer empId = permissionDto.getEmpId();
        Emp emp = permissionService.getEmpById(empId);
        if (null == emp) {
            responseVo.setCode("500");
            responseVo.setDescription("登录账号id为空");
            return responseVo;
        }
        Integer sysUserId = permissionDto.getSysUserId();
        SysUser sysUser = permissionService.getSysUserById(permissionDto.getSysUserId());
        if (null == sysUser) {
            responseVo.setCode("500");
            responseVo.setDescription("找不到员工信息");
            return responseVo;
        }
        int flag = permissionService.addSysUserPermission(permissionDto);
        if (1 == flag) {
            responseVo.setCode("200");
            responseVo.setDescription("权限维护成功");
            return responseVo;
        } else {
            responseVo.setCode("500");
            responseVo.setDescription("权限维护失败");
        }
        return responseVo;
    }

    @PostMapping("/getPermission")
    @ApiOperation(value = "查询用户权限")
    public Result getUserPermission(@RequestBody SearchPermissionDto searchPermissionDto){
        Result result = new Result();
        ArrayList<PermissionVo> permissionVos = permissionService.getPermissionBySysUserId(searchPermissionDto);
        if (permissionVos.size()<1 || null ==permissionVos){
            result.setDescription("权限为空");
        }else {

        }
        return ResultBuilder.success(permissionService.getPermissionBySysUserId(searchPermissionDto));
    }

    @PostMapping("/Permission")
    @ApiOperation(value = "测试通过String传输的时候获取值")
    public Result StringTest(@RequestBody String param){
        Map<String,Object> paramMap = JSON.parseObject(param,Map.class);
        String userId = paramMap.get("sysUserId").toString();
        return ResultBuilder.success(userId);
    }

}
