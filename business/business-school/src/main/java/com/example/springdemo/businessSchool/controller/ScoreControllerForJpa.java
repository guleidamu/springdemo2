package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.data.entity.Score;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.service.ScoreJpaService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(description = "学生信息接口")
@RestController
@RequestMapping(value = "/scoreJpa")
public class ScoreControllerForJpa {

    @Resource
    private ScoreJpaService scoreJpaService;

    @PostMapping("/addScore")
    public void addScore(@RequestBody Score score){
        scoreJpaService.save(score);
    }

    @PostMapping("/update")
    public void updateScore(@RequestBody Score score){
        scoreJpaService.update(score);
    }

    @PostMapping("/getScore")
    public Result getScore(@RequestBody Score score){
        return ResultBuilder.success(scoreJpaService.getScore(score));
    }

    @PostMapping("/deleteScore")
    public Result deleteScore(@RequestBody Score score){
        return ResultBuilder.success(scoreJpaService.deleteScore(score));
    }

    @PostMapping("/getScoreByScoreCondition")
    public Result getScoreByScoreCondition(){
        Result result = new Result();
        result.setData(scoreJpaService.getScoreByScoreCondition());
        return result;
    }


    @PostMapping("/getScoreByScore")
    public List<Score> getScoreByScore(@RequestBody Map<String,Object> json) {
        String scoreString = json.get("score").toString();
        int score = Integer.parseInt(scoreString);
        return scoreJpaService.getScoreByScore(score);
    }

    @PostMapping("/getCountByScore")
    public int getCountByScore( @RequestBody Map<String,Object> json) {
        String scoreString = json.get("score").toString();
        int score = Integer.parseInt(scoreString);
        return scoreJpaService.getCountByScore(score);
    }
}
