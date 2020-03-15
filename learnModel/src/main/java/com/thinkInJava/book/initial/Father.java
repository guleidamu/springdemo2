package com.thinkInJava.book.initial;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Father {
    private String name;

    private static String identity;

    static {
        log.info("父类静态代码块");
    }
    {
        log.info("父类初始化块");
    }

    private static void fatherStaticMethod(){
        log.info("这个是父类的static方法");
    }

//    public Father(){}

    public Father(String name){
        this.name = name;
        log.info("父类的name"+name);
    }

}
