package com.example.rabbitmq.config.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.one")
public class TopicOneReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicOneReceiver  : " +msg);
    }

}