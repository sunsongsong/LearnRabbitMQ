package com.example.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgReceiver {

    @RabbitListener(queues = RabbitConfig.userQueue)
    public void process(String content) {
        try {
            Thread.sleep(10000);
            System.out.println("content="+content);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitConfig.userQueue)
    public void process2(String content) {
        try {
            Thread.sleep(10000);
            System.out.println("content2="+content);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
