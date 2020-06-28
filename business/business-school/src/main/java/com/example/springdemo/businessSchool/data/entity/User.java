package com.example.springdemo.businessSchool.data.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    private int id;
    private String userName;
    private String phone;
    private String password;
    private String salt;
    private String head;
    private int loginCount;
    private Date registerDate;
    private Date lastLoginDate;
}
