package com.thinkInJava.book.object;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private Integer sno;

    private Integer classNo;

    private String studentName;

    public Student(){}

    public Student(int sno, int classNo1, String studentName ){
        this.sno = sno;
        this.classNo = classNo1;
        this.studentName = studentName;
    }
}
