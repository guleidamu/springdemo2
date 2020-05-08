package com.thinkInJava.book.MS.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
//@Data会重写equals方法
//@Data
public class Person implements Serializable {
    private Integer id;

    private String personName;

//    public Person() {
//    }

    public Person(String personName){
        this.personName = personName;
    }
}
