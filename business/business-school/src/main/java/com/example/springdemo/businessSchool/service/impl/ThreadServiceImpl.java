package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.entity.Student;
import com.example.springdemo.businessSchool.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:16 2020/6/28
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Service
public class ThreadServiceImpl implements ThreadService {



    @Override
    public void getTest() {
        Student student = new Student();
        synchronized  (student){
            try {
                for (int i =1; i<100;i++){
                    log.info(Thread.currentThread().getName());
                    student.wait(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async
    @Override
    public void getTest1() {
        Student student = new Student();
        synchronized  (student){
            try {
                for (int i =1; i<100;i++){
                    log.info(Thread.currentThread().getName() + "异步" + i);
                    student.wait(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
