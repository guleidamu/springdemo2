package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.dto.UserDTO;
import com.example.springdemo.businessSchool.data.entity.User;
import com.example.springdemo.businessSchool.response.Result;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:31 2020/6/22
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface UserService {

    Result<User> login(UserDTO userDTO);
}
