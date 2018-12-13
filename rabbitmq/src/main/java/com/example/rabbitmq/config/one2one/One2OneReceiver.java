package com.example.rabbitmq.config.one2one;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  one2one队列的消息接受者
 */
@Component
@RabbitListener(queues = "one2one") //监听改队列的消息
public class One2OneReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("One2OneReceiver  : " + hello);
    }

}
