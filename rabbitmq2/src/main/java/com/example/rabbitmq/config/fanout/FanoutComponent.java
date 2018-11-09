package com.example.rabbitmq.config.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 可以将配置的监听写在一起
 */
@Component
public class FanoutComponent {

    @RabbitListener(queues="fanout.A")
    public void processA(String str) {
        System.out.println("ReceiveA:"+str);
    }

    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}
