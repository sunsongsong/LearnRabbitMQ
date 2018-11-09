package com.example.rabbitmq.config.beanSender;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(RabbitUser user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }

}
