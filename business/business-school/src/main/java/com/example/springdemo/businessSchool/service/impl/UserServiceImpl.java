package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.dto.UserDTO;
import com.example.springdemo.businessSchool.data.entity.User;
import com.example.springdemo.businessSchool.mapper.UserMapper;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.response.ResultCode;
import com.example.springdemo.businessSchool.service.UserService;
import com.example.springdemo.businessSchool.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:32 2020/6/22
 * @ Modified By：
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result<User> login(UserDTO userDTO) {

        User user = userMapper.checkPhone(userDTO.getUserName());
        if(null == user){
            return ResultBuilder.error(ResultCode.USER_NOTFOUND);

        }
        String password = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(userDTO.getPassword(), saltDB);
        if(!StringUtils.equals(password, calcPass)){
            return ResultBuilder.error(ResultCode.ERROR_PASSWORD);
        }
        return ResultBuilder.success(user);
    }
}
