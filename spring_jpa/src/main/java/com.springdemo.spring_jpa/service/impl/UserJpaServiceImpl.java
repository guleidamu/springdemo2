package com.springdemo.spring_jpa.service.impl;

import com.springdemo.spring_jpa.dao.first.UserRepository;
import com.springdemo.spring_jpa.domain.User;
import com.springdemo.spring_jpa.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:24 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
@Service
public class UserJpaServiceImpl implements UserJpaService {

    @Autowired
    private UserRepository userJpaRepository;


    public int save(User user) {
//        user.setCreateTime(new Date());
        User user1 =  userJpaRepository.save(user);
        return 1;
    }

    @Override
    public User update(User user) {
        User userFromDB = userJpaRepository.findById(user.getId()).get();
        if(null == userFromDB){
            return null;
        }
//        userFromDB.setUser(user.getUser());
//        userFromDB.setCno(user.getCno());
//        userFromDB.setSno(user.getSno());
        return userJpaRepository.save(userFromDB);
    }

    @Override
    public User getUser(User user) {
        return userJpaRepository.findById(user.getId()).get();
    }

    @Override
    public int deleteUser(User user) {
        userJpaRepository.deleteById(user.getId());
        return 1;
    }

    @Override
    public List<User> getUserByUserCondition() {
        return userJpaRepository.getUserByUserCondition();
    }

    @Override
    public List<User> getUserByUser(int user) {
        return userJpaRepository.getUserByUser(user);
    }

    @Override
    public int getCountByUser(int user) {
        return userJpaRepository.getCountByUser(user);
    }
}
