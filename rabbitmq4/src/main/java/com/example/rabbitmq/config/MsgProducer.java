package com.example.rabbitmq.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String content) {
        System.out.println("MsgProducer 发送的内容为 : " + content);
        this.rabbitTemplate.convertAndSend(RabbitConfig.userQueue, content);
    }
}
