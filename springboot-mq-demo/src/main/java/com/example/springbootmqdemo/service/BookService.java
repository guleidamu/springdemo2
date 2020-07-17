package com.example.springbootmqdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootmqdemo.model.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息:" + book);

    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message){
//        byte[] body = message.getBody();
        System.out.println("atguigu队列收到消息转换" +new String(message.getBody()));
        System.out.println("atguigu队列收到消息" + message.toString());
        System.out.println("atguigu队列收到消息" + message.getBody());
//        System.out.println("atguigu队列收到消息" + message.getMessageProperties());
        String bookString = new String(message.getBody());
        try {
            Book book5 = JSONObject.parseObject(bookString,Book.class);
            Book book6= JSONObject.parseObject(bookString,Book.class);
            System.out.println("作者" + book5.getAuthor());
            System.out.println("书名" + book5.getBookName());
            System.out.println("作者" + book6.getAuthor());
            System.out.println("书名" + book6.getBookName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
