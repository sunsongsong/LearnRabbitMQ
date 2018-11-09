package com.example.rabbitmq.config.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.two")
public class TopicTwoReceiver {

    @RabbitHandler
    public void process(String msg) {
        int i = 1/0;
        System.out.println("TopicTwoReceiver  : 我他妈绑定了topic.#的路由键,所有topic开头的都得给老子过来.. 爷爷 " +msg);
    }


    

}
