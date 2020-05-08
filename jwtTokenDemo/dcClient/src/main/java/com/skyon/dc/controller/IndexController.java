package com.skyon.dc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/da/token")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "service two";
    }
}
