package com.example.springdemo.businessSchool.constant;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:52 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
public class Const {

    public interface RedisCacheExtime{
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
        int GOODS_LIST = 60 * 30 * 24;//1分钟
        int GOODS_ID = 60;//1分钟
        int SECKILL_PATH = 60;//1分钟
        int GOODS_INFO = 60;//1分钟
    }
}
