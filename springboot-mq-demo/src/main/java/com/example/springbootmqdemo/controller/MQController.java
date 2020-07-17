package com.example.springbootmqdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootmqdemo.model.Book;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:59 2020/7/16
 * @ Modified By：
 * @Version: 1.0.0
 */
@RestController
public class MQController {

    //API：amqpTemplate.convertAndSend("交换机名"，“路由键”，“消息内容”)

    @Autowired
    private AmqpTemplate amqpTemplate;
    @GetMapping("/send")
    public String send(){
        String content="Date:"+new Date();
        Book book = new Book("曾国藩","小弟");
        String bookString = JSONObject.toJSONString(book);
        amqpTemplate.convertAndSend("exchange.direct","atguigu",book);
//        amqpTemplate.convertAndSend("exchange.direct","atguigu",bookString);
//        amqpTemplate.convertAndSend("exchange.topic","atguigu.#",bookString);
        Book book5 = JSONObject.parseObject(bookString,Book.class);
        return book.toString();
    }

//    public static void main(String[] args) {
//        MQController mqController = new MQController();
//        mqController.send();
//    }

}
