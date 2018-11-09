package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMQ的配置信息,根据配置信息,自动注册到rabbitmq中
 */
@Configuration
public class RabbitConfig {

    /**
     * 实体bean传输的队列
     * @return
     */
    @Bean
    public Queue userQueue(){
        return new Queue("userQueue");
    }




}
