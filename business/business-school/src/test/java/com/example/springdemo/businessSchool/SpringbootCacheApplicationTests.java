package com.example.springdemo.businessSchool;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.businessSchool.data.dto.SearchStudentDto;
import com.example.springdemo.businessSchool.data.vo.StudentVo;
import com.example.springdemo.businessSchool.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.T;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    RedisTemplate redisTemplate; //k-v都是对象

    @Resource
    StringRedisTemplate stringRedisTemplate; //操作字符串

    @Resource
//    RedisTemplate<Object, SearchStudentDto> redisTemplateSer;
      RedisTemplate<String, Object> redisTemplateSer;

    /**
     * redis常见的五大数据类型
     * String（字符串） list（列表），set（集合），Hash（散列），ZSet（有序集合）
     * stringRedisTemplate.opsForValue() String字符串
     * stringRedisTemplate.opsForList()
     * stringRedisTemplate.opsForSet()
     * stringRedisTemplate.opsForHash()
     * stringRedisTemplate.opsForZSet()
     */

//    @Test
//    public void test01(){
//        //给redis中保存一个数据
////        stringRedisTemplate.opsForValue().append("msg","hello");
////        String message = stringRedisTemplate.opsForValue().get("msg");
////        System.out.println("message:" + message);
//
////        stringRedisTemplate.opsForList().leftPush("mylist","1");
////        stringRedisTemplate.opsForList().leftPush("mylist","2");
//    }


    //测试保存对象
    @Test
    public void test02(){
        SearchStudentDto searchStudentDto = new SearchStudentDto();
        searchStudentDto.setName("kadaqia");
        searchStudentDto.setNum(6);
        searchStudentDto.setPageCode(6);
        searchStudentDto.setPageSize(1);
        List<StudentVo> studentVolist = studentMapper.getStudentByName(searchStudentDto.getName());
        redisTemplate.opsForValue().set("stud1",searchStudentDto,30, TimeUnit.SECONDS);
        //1.将数据以json的方式保存
        //（1）手动转换为json
        //（2）redisTemplate默认的序列化规则
        redisTemplateSer.opsForValue().set("emp-01",searchStudentDto,30, TimeUnit.SECONDS);

        Object object = new Object();
        SearchStudentDto searchStudentDtoS1 = new SearchStudentDto ();
        try {
            object = redisTemplateSer.opsForValue().get("emp-01");
            searchStudentDtoS1 = JSON.parseObject(JSON.toJSONString(object),SearchStudentDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("object" + object);
        System.out.println("searchStudentDtoS1:" + JSON.toJSONString(searchStudentDtoS1));
    }
}
