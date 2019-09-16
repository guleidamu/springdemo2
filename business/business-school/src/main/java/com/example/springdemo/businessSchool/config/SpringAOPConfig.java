package com.example.springdemo.businessSchool.config;

import com.alibaba.fastjson.JSONObject;
import com.example.springdemo.businessSchool.data.entity.ActionLog;
import com.example.springdemo.businessSchool.mapper.ActionLogMapper;
import com.example.springdemo.businessSchool.service.utils.SkillsUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Aspect
@Component
public class SpringAOPConfig {
    private static final Logger logger = LoggerFactory.getLogger(SpringAOPConfig.class);

    @Resource
    private ActionLogMapper actionLogMapper;

    @Pointcut("@annotation(com.example.springdemo.businessSchool.data.dict.LogRecord)")
    public void LogPointcut(){}

    @Before("LogPointcut()")
    public void deBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ActionLog actionLog = new ActionLog();
        actionLog.setActionContent(request.getRequestURI().trim());
        actionLog.setActionIp(SkillsUtils.getIpAddress(request));
        actionLog.setActionTime(new Date());
        Object[] params = joinPoint.getArgs();
        try {
            String StaffTest = String.valueOf(JSONObject.parseArray(JSONObject.toJSONString(params), Map.class).get(0));
            actionLog.setActionStaff(StaffTest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int des = actionLogMapper.insertActionLog(actionLog);
    }

    public void doAfterReturning(Object ret){

    }

}
