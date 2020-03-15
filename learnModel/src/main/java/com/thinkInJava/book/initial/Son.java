package com.thinkInJava.book.initial;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Son extends Father {

    private String sonName;

    private static String sonIdentity;

    static {
        log.info("子类静态代码块");
    }
    {
        log.info("子类初始化块");
    }

    private static void sonStaticMethod(){
        log.info("这个是子类的static方法");
    }

    //一个类只要有父类，那么在它实例化的时候，一定是从顶级的父类开始创建。对于Java来说要一直追述到Object
    //祖宗（Object）-> 曾爷爷 -> 爷爷 -> 父亲 -> me
    public Son(String sonName){
        super(sonName);
        this.sonName = sonName;
        log.info("子类的name"+sonName);
    }
}
