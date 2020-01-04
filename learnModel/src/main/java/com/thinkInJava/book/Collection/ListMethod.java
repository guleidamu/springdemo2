package com.thinkInJava.book.Collection;

import com.thinkInJava.book.object.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListMethod {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        log.info("studentList的长度" + studentList.size());
        log.info("studentArrayList的初始化长度" + studentArrayList.size());
    }
}
