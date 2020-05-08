package com.skyon.dc.controller;

import com.skyon.dc.config.ClientTokenUtil;
import com.skyon.dc.model.dto.TokenDto;
import com.skyon.dc.vo.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/da/token")
public class IndexController {
    @Autowired
    private ClientTokenUtil clientTokenUtil;

    @GetMapping("/index")
    public String index() {
        return "service one";
    }

    @PostMapping("add")
    public String addToken(@RequestBody TokenDto tokenDto) {
        String userId = tokenDto.getUserId();
        String userName = tokenDto.getUserName();
        String mac = tokenDto.getMac();
        Integer expire = tokenDto.getExpire();
        try {
            String token = clientTokenUtil.generateToken(new JWTInfo(userId,userName,mac),expire);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "add success";
    }
}
