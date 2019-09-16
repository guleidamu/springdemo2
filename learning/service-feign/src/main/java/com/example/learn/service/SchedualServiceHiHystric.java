package com.example.learn.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

