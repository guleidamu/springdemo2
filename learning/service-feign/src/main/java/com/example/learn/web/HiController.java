package com.example.learn.web;

import com.example.learn.service.FeignService;
//import com.example.learn.service.SchedualService;
//import com.example.learn.service.SchedualServiceHi;
import com.example.learn.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

//    @RequestMapping("/hi")
//    public String home(@RequestParam String name) {
//        return "hi " + name + ",i am from port:" + "8765";
//    }

}


