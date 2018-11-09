package com.example.rabbitmq.config.beanSender;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(RabbitUser user) {
        String now = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(new Date());
        System.out.println(now + " retry... ");
        int i = 1/0;
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }

}
