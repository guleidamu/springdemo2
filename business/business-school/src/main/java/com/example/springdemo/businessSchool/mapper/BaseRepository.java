package com.example.springdemo.businessSchool.mapper;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphPagingAndSortingRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryByExampleExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 19:16 2020/7/1
 * @ Modified By：
 * @Version: 1.0.0
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID>, EntityGraphJpaRepository<T, ID>,
        EntityGraphPagingAndSortingRepository<T, ID>,
        EntityGraphQueryByExampleExecutor<T>, EntityGraphJpaSpecificationExecutor<T> {}
