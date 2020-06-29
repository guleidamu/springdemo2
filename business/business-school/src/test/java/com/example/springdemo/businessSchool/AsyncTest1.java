package com.example.springdemo.businessSchool;

import com.example.springdemo.businessSchool.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:43 2020/6/28
 * @ Modified By：
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusinessSchoolApplication.class)
public class AsyncTest1 {

    @Resource
    private AsyncService asyncService;

    @Test
    public void asyncTest() throws InterruptedException{
        for (int i = 0; i< 10; i++){
            asyncService.executeAsync1();
            asyncService.executeAsync2();
        }
        Thread.sleep(1000);
    }
}
