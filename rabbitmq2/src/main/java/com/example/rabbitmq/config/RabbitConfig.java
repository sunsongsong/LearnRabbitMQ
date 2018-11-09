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
     * 一对一队列信息配置
     * @return
     */
    @Bean
    public Queue one2one(){
        return new Queue("one2one");
    }

    /**
     * 一对多队列信息配置
     * @return
     */
    @Bean
    public Queue one2more(){
        return new Queue("one2more");
    }

    /**
     * 多对多队列信息配置
     * @return
     */
    @Bean
    public Queue more2more() {
        return new Queue("more2more");
    }

    /**
     * 实体bean传输的队列
     * @return
     */
    @Bean
    public Queue userQueue(){
        return new Queue("userQueue");
    }


    /**===============以下是验证topic Exchange的队列==========*/

    @Bean
    public Queue queueOne() {
        return new Queue("topic.one");
    }

    @Bean
    public Queue queueTwo() {
        return new Queue("topic.two");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 将队列 topic.one 与exchange绑定，binding_key为topic.one,就是完全匹配
     * @param queueOne
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeOne(Queue queueOne, TopicExchange exchange) {
        return BindingBuilder.bind(queueOne).to(exchange).with("topic.one");
    }

    /**
     * 将队列 topic.two 与exchange绑定，binding_key为topic.#,模糊匹配
     * @param queueTwo
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeTwo(Queue queueTwo, TopicExchange exchange) {
        return BindingBuilder.bind(queueTwo).to(exchange).with("topic.#");
    }

    /**===============以上是验证topic Exchange的队列==========*/




    /**===============以下是验证Fanout Exchange的队列==========*/
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
    /**===============以上是验证Fanout Exchange的队列==========*/



}
