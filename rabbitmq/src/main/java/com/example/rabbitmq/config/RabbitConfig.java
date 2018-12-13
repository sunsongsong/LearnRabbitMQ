package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMQ的配置信息
 */
@Configuration
public class RabbitConfig {

    /**
     * 一对一队列信息配置
     * @return
     */
    @Bean
    public Queue one2one(){
        return new Queue("one2one");
    }

}
