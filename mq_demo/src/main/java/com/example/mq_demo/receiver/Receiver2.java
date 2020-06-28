package com.example.mq_demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "lyhTest2")
public class Receiver2 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("Test2 receiver2:"+msg);
    }
}
