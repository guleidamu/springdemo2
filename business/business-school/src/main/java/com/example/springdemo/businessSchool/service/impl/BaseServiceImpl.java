package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.mapper.BaseRepository;
import com.example.springdemo.businessSchool.service.BaseService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 19:29 2020/7/1
 * @ Modified By：
 * @Version: 1.0.0
 */
public class BaseServiceImpl<S extends BaseRepository<T, Serializable>, T> implements BaseService<T> {

    @Autowired
    private S baseRepository;

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public T getById(Serializable id) {
        return baseRepository.getOne(id);
    }

//    @Override
//    public T findById(Serializable id) {
//        return baseRepository.findById(id).orElse(null);
//    }

    @Override
    public void deleteById(Serializable id) {
        baseRepository.deleteById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }


    @Override
    public Page<T> findAll(T t, Set<String> exampleMatchPropertySets, Pageable pageable) {
        if(t == null)
            return this.findAll(pageable);
        ExampleMatcher matcher = ExampleMatcher.matching();
        matcher=matcher.withIgnoreNullValues();
        if(exampleMatchPropertySets!=null && exampleMatchPropertySets.size()>0){
            for(String propName:exampleMatchPropertySets){
                matcher = matcher.withMatcher(propName, ExampleMatcher.GenericPropertyMatchers.storeDefaultMatching());
            }
        }
        Example<T> e = Example.of(t, matcher);
        return baseRepository.findAll(e, pageable);
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

    @Override
    public long count(T t, Set<String> exampleMatchPropertySets) {
        if(t == null)
            return this.count();
        ExampleMatcher matcher = ExampleMatcher.matching();
        matcher=matcher.withIgnoreNullValues();
        if(exampleMatchPropertySets!=null && exampleMatchPropertySets.size()>0){
            for(String propName:exampleMatchPropertySets){
                matcher = matcher.withMatcher(propName, ExampleMatcher.GenericPropertyMatchers.contains());
            }
        }
        Example<T> e = Example.of(t, matcher);
        return baseRepository.count(e);
    }
}
