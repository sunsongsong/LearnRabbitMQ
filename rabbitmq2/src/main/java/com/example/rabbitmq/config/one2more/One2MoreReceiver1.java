package com.example.rabbitmq.config.one2more;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "one2more")
public class One2MoreReceiver1 {

    @RabbitHandler
    public void process(String helloQueue) {
        System.out.println("One2MoreReceiver1  : " + helloQueue);
    }




}
