package com.lc.helloworld;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class Recv {

    private final static String QUEUE_NAME = "publish_confirm_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.31.203");
        //factory.setPort(15672);
        factory.setUsername("admin");
        factory.setPassword("password");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };

        CancelCallback cancelCallback = consumerTag -> System.out.println("消息被中断");

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
