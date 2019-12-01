package com.thinkInJava.book.excel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private String id;

    private String name;

    private String sex;
}
