package com.example.rabbitmq5.chapter2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 代码清单1-2 消费者客户端代码
 */
public class AckConsumer {
    private static final String QUEUE_NAME = "queue_demo";

    private static final String IP_ADDRESS = "127.0.0.1";

    private static final int PORT = 5672 ;

    public static void main(String[] args) throws IOException,
            TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{
                new Address(IP_ADDRESS, PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //这里的连接方式与生产者的 demo 略有不同 ， 注意辨别区别
        Connection connection = factory.newConnection(addresses); //创建连接
        final Channel channel = connection.createChannel(); //创建信道
        channel.basicQos(64) ; // 设置客户端最多接收未被 ack 的消息的个数
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                    Envelope envelope,
                    AMQP.BasicProperties properties,
                    byte [] body) throws IOException {

                System.out.println( "recvmessage:" + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 手动进行ACK
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME,false, consumer);//不自动确定,需要手动确认
        //等待回调函数执行完毕之后 ， 关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}