package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.dto.UserDTO;
import com.example.springdemo.businessSchool.data.entity.User;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:33 2020/6/22
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface UserMapper {

    User checkPhone(String phone);
}
