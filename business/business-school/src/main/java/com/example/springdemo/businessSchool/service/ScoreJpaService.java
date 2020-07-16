package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.entity.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

//public interface ScoreJpaService extends BaseService<Score> {
public interface ScoreJpaService {




    int save(Score score);




    /**
     * 根据给定的实体，查询所有的数据；
     */
//    Page<Score> findAll(Score score, Pageable pageable);

    /**
     * @Desc
     * 根据供应商的相关信息以及内部接口信息进行分页查询
     * @Params [provider, score, pageableOld]
     * @return org.springframework.data.domain.Page<com.skyon.lily.model.Score>
     */
//    public Page<Score> findAll(Provider provider, Score score, Pageable pageableOld);


    /**
     * 修改；
     */
    Score update(Score score);

    Score getScore(Score score);

    int deleteScore(Score score);

    List<Score> getScoreByScoreCondition();

    List<Score> getScoreByScore(int score );

    int getCountByScore(int score);


}
