package com.example.springdemo.businessSchool.data.entity;

//import lombok.Setter;
//
//import lombok.Getter;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "student")
public class StudentForJPA  implements Serializable {

    @Id
    @GeneratedValue
    private Long studentNo;

    @Column(name = "name", nullable = true, length = 20)
    private String studentName;

    @Column(name = "studentSex", nullable = true, length = 20)
    private String studentSex;

    @Column(name = "classNo", nullable = true, length = 20)
    private String classNo;

}
