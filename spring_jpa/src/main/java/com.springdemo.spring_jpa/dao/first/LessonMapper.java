package com.springdemo.spring_jpa.dao.first;

import com.springdemo.spring_jpa.domain.Lesson;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:08 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface LessonMapper {
    List<Lesson> findById(Integer id);
}
