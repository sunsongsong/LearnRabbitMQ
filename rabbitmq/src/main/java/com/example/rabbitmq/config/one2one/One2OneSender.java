package com.example.rabbitmq.config.one2one;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * one2one队列的消息发送者
 */
@Component
public class One2OneSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String name) {
        String sendMsg = "hello one2one weclome " + name;
        System.out.println("One2OneSender : " + sendMsg);
        this.rabbitTemplate.convertAndSend("one2one", sendMsg);
    }


}
