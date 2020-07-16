package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.entity.Score;
import com.example.springdemo.businessSchool.mapper.ScoreJpaRepository;
import com.example.springdemo.businessSchool.service.ScoreJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
//public class ScoreJpaServiceImpl extends BaseServiceImpl<ScoreJpaRepository, Score> implements ScoreJpaService {
public class ScoreJpaServiceImpl implements ScoreJpaService {

    @Autowired
    private ScoreJpaRepository scoreJpaRepository;


    public int save(Score score) {
        score.setCreateTime(new Date());
        Score score1 =  scoreJpaRepository.save(score);
        return 1;
    }

    @Override
    public Score update(Score score) {
        Score scoreFromDB = scoreJpaRepository.findById(score.getId()).get();
        if(null == scoreFromDB){
            return null;
        }
        scoreFromDB.setScore(score.getScore());
        scoreFromDB.setCno(score.getCno());
        scoreFromDB.setSno(score.getSno());
        return scoreJpaRepository.save(scoreFromDB);
    }

    @Override
    public Score getScore(Score score) {
        return scoreJpaRepository.findById(score.getId()).get();
    }

    @Override
    public int deleteScore(Score score) {
        scoreJpaRepository.deleteById(score.getId());
        return 1;
    }

    @Override
    public List<Score> getScoreByScoreCondition() {
        return scoreJpaRepository.getScoreByScoreCondition();
    }

    @Override
    public List<Score> getScoreByScore(int score) {
        return scoreJpaRepository.getScoreByScore(score);
    }

    @Override
    public int getCountByScore(int score) {
        return scoreJpaRepository.getCountByScore(score);
    }
}
