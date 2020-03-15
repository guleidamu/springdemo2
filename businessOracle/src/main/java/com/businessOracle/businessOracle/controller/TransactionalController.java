package com.businessOracle.businessOracle.controller;

import com.businessOracle.businessOracle.service.TransactionalServer;
import com.businessOracle.businessOracle.service.impl.TransactionalServerImpl;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/transactional")
@RestController
public class TransactionalController {

    private TransactionalServer transactionalServerImpl;

    @PostMapping(value = "/tralsactional")
    public Result getStudent() {
        return ResultBuilder.success(transactionalServerImpl.addData());
    }

}
