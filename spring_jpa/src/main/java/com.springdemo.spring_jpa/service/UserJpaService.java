package com.springdemo.spring_jpa.service;

import com.springdemo.spring_jpa.domain.User;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:20 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface UserJpaService {





    int save(User user);




    /**
     * 根据给定的实体，查询所有的数据；
     */
//    Page<User> findAll(User user, Pageable pageable);

    /**
     * @Desc
     * 根据供应商的相关信息以及内部接口信息进行分页查询
     * @Params [provider, user, pageableOld]
     * @return org.springframework.data.domain.Page<com.skyon.lily.model.User>
     */
//    public Page<User> findAll(Provider provider, User user, Pageable pageableOld);


    /**
     * 修改；
     */
    User update(User user);

    User getUser(User user);

    int deleteUser(User user);

    List<User> getUserByUserCondition();

    List<User> getUserByUser(int user );

    int getCountByUser(int user);
}
