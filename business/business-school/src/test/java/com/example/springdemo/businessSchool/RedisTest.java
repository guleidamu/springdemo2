package com.example.springdemo.businessSchool;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {
       Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        System.out.println("k5:" + jedis.get("k5"));
        Set<String> sets = jedis.keys("*");
        for (String setString : sets){
            System.out.println(setString);
        }
        System.out.println("k5:" + jedis.get("key *"));
        System.out.println("searchStudentDto::陈:" + jedis.get("searchStudentDto::陈"));
    }
}
