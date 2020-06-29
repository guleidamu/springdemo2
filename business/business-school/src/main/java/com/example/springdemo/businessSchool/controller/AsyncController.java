package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.service.RunnableTask1;
import com.example.springdemo.businessSchool.service.ThreadService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 10:11 2020/6/28
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Api(description = "异步async")
@RestController
@EnableAsync
@RequestMapping(value = "/async")
public class AsyncController {

    @Resource
    private ThreadService threadServiceImpl;

    @GetMapping(value = "/synchronous")
    public String synchronous(){
        threadServiceImpl.getTest();
        log.info(Thread.currentThread().getName());
        return "同步，正在解析。。。。。。";
    }


    /**
     * 异步处理1：线程池，创建新线程处理
     * @return
     */
    @RequestMapping(value = "async1",method = RequestMethod.GET)
    public String test3(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        RunnableTask1 task1 = new RunnableTask1();
        service.execute(task1);
        log.info("=========》当前线程名："+Thread.currentThread().getName());
        return "异步,正在解析......";
    }

    /**
     * 3.异步任务 方式二
     *
     * 这种方式，是springBoot自身的一种异步方式，使用注解实现，
     * 非常方便，我们在想要异步执行的方法上加上@Async注解，在controller上加上@EnableAsync，即可。
     * 注意，这里的异步方法，只能在自身之外调用，在本类调用是无效的。
     */

    @RequestMapping(value = "async2",method = RequestMethod.GET)
    public String test1(){
        threadServiceImpl.getTest1();
        log.info("============>"+Thread.currentThread().getName());
        return "异步,正在解析......";
    }


}
