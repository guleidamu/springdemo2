package com.example.springdemo.businessSchool.data.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:25 2020/6/22
 * @ Modified By：
 * @Version: 1.0.0
 */
@Data
public class UserDTO implements Serializable {

    private String userName;

    private String password;
}
