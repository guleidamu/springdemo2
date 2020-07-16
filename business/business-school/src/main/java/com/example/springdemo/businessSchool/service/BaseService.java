package com.example.springdemo.businessSchool.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 19:10 2020/7/1
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface BaseService<T> {

    /**
     * 保存
     */

    T save(T entity);

    /**
     * 根据ID查询实例,实例不能为空
     * @param id
     * @return
     */
    T getById(Serializable id);

    /**
     * 根据ID查询实例，实例为空时返回null
     * @param id
     * @return
     */
//    T findById(Serializable id);

    /**
     * 根据ID删除实例
     */
    void deleteById(Serializable id);

    /**
     * 分页查询
     */
    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    Page<T> findAll(T t, Set<String> exampleMatchPropertySets, Pageable pageable);

    long count();

    long count(T t, Set<String> exampleMatchPropertySets);
}
