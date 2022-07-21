package com.lc.exchange.dlx;

import com.lc.utils.RabbitMQUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;

public class Consumer1 {
    public static String NORMAL_QUEUE="normal_queue";
    public static String NORMAL_EXCHANGE="normal_exchange";
    public static String DEAD_QUEUE="dead_queue";
    public static String DEAD_EXCHANGE="dead_exchange";


    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMQUtils.getChannel();
        assert channel != null;
        channel.queueDeclare(NORMAL_QUEUE,true,false,false,null);
        channel.queueDeclare(DEAD_QUEUE,true,false,false,null);
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE,BuiltinExchangeType.DIRECT);


    }
}
