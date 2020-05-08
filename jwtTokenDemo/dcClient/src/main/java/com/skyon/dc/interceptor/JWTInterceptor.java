package com.skyon.dc.interceptor;

import com.skyon.dc.config.ClientTokenUtil;
import com.skyon.dc.vo.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTInterceptor implements HandlerInterceptor {

    private String screct;

    @Autowired
    private ClientTokenUtil clientTokenUtil;

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object obj, Exception e)
        throws Exception{

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
        throws Exception{

    }

    //拦截每个请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws IOException{
        String jwt = request.getHeader("Authorization");
        System.out.println(jwt);
        try {
            if(jwt != null){
                JWTInfo jwtInfo = clientTokenUtil.getInfoFromToken(jwt);
                System.out.println("USER MAC" + jwtInfo.getMac());
                return true;
            }
            response.getWriter().write("token is null.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("token is expired.");
        return false;
    }
}
