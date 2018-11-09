package com.example.rabbitmq.config.more2more;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "more2more")
public class More2MoreReceiver2 {

    @RabbitHandler
    public void process(String helloQueue) {
        System.out.println("More2MoreReceiver2  : " + helloQueue);
    }

}
