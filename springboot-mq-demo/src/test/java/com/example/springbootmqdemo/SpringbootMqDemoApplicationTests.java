package com.example.springbootmqdemo;

import com.example.springbootmqdemo.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootMqDemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
    }

    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
    }

    @Test
    public void createBinding(){
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.haha",null));
    }

    /**
     * 单播（点对点）
     */
    @Test
    void contextLoads() {
        //message需要自己构造一个；定制消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);
        //

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是一个消息");
        map.put("data", Arrays.asList("helloWorld",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }


    //接收数据，如何将数据自动的转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receive("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));
    }

}
