//package com.example.springdemo.businessSchool.config.security;
//
//
//import com.alibaba.fastjson.JSON;
//import com.example.springdemo.businessSchool.response.Result;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 登陆之后发生的权限不足的处理器
// * @author 19624
// */
//@Component
//public class SecurityAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//        Result responseBody = new Result("ResponseMsg.fail(\"权限不足，联系管理员!\")");;
//        httpServletResponse.setCharacterEncoding("utf-8");
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
//        httpServletResponse.setStatus(403);
//    }
//}
