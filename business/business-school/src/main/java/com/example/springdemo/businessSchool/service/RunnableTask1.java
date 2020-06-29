package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.entity.Student;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:36 2020/6/28
 * @ Modified By：
 * @Version: 1.0.0
 */
public class RunnableTask1 implements Runnable{
    @Override
    public void run() {
        Student student = new Student();
        synchronized(student){
            try {
                for(int i =1; i<= 100; i++){
                    System.out.println(Thread.currentThread().getName()+"----------异步：>" + i);
                    student.wait(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
