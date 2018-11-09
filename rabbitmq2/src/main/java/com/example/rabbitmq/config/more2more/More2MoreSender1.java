package com.example.rabbitmq.config.more2more;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class More2MoreSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String name) {
        String sendMsg = "hello one2one weclome " + name;
        System.out.println("More2MoreSender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("more2more", sendMsg);
    }
}
