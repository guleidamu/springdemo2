package com.springdemo.spring_jpa;

import com.springdemo.spring_jpa.dao.first.UserRepository;
import com.springdemo.spring_jpa.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 12:57 2020/7/2
 * @ Modified By：
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    /**
     * 初始化一个对象 User 测试Insert过程
     * */
    @Before
    public void before(){
        User user =new User();
        user.setId(17);
        user.setUserName("fishpro");
        user.setSex(1);
        user.setLastLoginTime(new Date());
        user.setPassword("passWord");
        userRepository.save(user);
    }

    @Test
    public void testAddUser(){
        User user =new User();
//        user.setId(27);
        user.setUserName("fishpro0704");
        user.setSex(1);
        user.setLastLoginTime(new Date());
        user.setPassword("passWord");
        userRepository.save(user);
        user =new User();
//        user.setId(3);
        user.setUserName("fishpro3");
        user.setSex(1);
        user.setLastLoginTime(new Date());
        user.setPassword("passWord");
        userRepository.save(user);
    }
    @Test
    public void testFind(){
        Optional<User> optionalUserDO=userRepository.findById(17);
        if(optionalUserDO.isPresent()){
            User user =optionalUserDO.get();
            System.out.println("testFind user"+ user.getUserName());
        }
    }

    @Test
    public void testUpdate(){
        Optional<User> optionalUserDO=userRepository.findById(17);
        if(optionalUserDO.isPresent()){
            User user =optionalUserDO.get();
            user.setUserName("fishpro00000001");
            userRepository.save(user);
            System.out.println("testFind user"+ user.getUserName());
        }

    }

    @Test
    public void testDelete(){
        userRepository.deleteById(17);
    }

    @Test
    public void testFindAll(){
        List<User> list=userRepository.findAll();
        for (User user:list
        ) {
            System.out.println("user_name:"+user.getUserName());
        }
    }

    @After
    public void after(){
    }

}
