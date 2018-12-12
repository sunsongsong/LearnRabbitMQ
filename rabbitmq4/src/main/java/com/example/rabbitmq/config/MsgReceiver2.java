package com.example.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;

@Component
public class MsgReceiver2 {

    @Autowired
    ThreadPoolExecutor taskExecutor;

    /**
     * 消耗时间：1544603012197 - 1544603010461
     * @param content
     */
    @RabbitListener(queues = RabbitConfig.userQueue)
    public void process(String content) {
        taskExecutor.execute(()->{
            try {
                sleep(5000);
                System.out.println("MyThread: "+content+" "+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 消耗时间：1544602949618 - 1544602898628
     * @param content
     */
//    @RabbitListener(queues = RabbitConfig.userQueue)
    public void process2(String content) {
        try {
            Thread.sleep(1000);
            System.out.println("process2: "+content+" "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
