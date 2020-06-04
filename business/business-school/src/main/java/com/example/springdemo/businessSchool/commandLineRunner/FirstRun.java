package com.example.springdemo.businessSchool.commandLineRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirstRun implements CommandLineRunner {
    //听说继承CommandLineRunner（函数式接口），实现他的run方法，可以在类启动的时候就执行这个方法。
    @Override
    public void run(String... args) throws Exception {
        log.info(getClass().getName()+ "  听说继承CommandLineRunner（函数式接口），实现他的run方法，可以在类启动的时候就执行这个方法。");
    }
}
