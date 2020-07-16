package com.springdemo.spring_jpa.dao.first;

import com.springdemo.spring_jpa.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 12:47 2020/7/2
 * @ Modified By：
 * @Version: 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from  User where User.score > 90",nativeQuery = true)
    List<User> getUserByUserCondition();

    @Query(value = "select * from  User where User.score > ?1",nativeQuery = true)
    public List<User> getUserByUser(int score );

    @Query(value = "select count(*) from  User where User.score > ?1",nativeQuery = true)
    int getCountByUser(int score);
}
