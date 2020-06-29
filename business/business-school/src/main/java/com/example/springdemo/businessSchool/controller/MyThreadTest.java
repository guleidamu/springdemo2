package com.example.springdemo.businessSchool.controller;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:42 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class MyThreadTest {
    public static void main(String[] args) {
        for (int i = 1; i <=10; i++) {
            new MyThread().start();
        }
    }
}
