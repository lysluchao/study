package com.lc.helloworld;

import com.lc.utils.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.MessageProperties;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class MutiRecv {


    public static void main(String[] args) throws IOException, InterruptedException {
        MutiSend mutiSend = new MutiSend();
        Thread threadSend = new Thread(mutiSend);
        threadSend.start();

        MutiRecvWork mutiRecvWork1 = new MutiRecvWork("C1");
        MutiRecvWork mutiRecvWork2 = new MutiRecvWork("C2");
        Thread t1 = new Thread(mutiRecvWork1);
        t1.start();
        Thread t2 = new Thread(mutiRecvWork2);
        t2.start();

    }
}

@AllArgsConstructor
class MutiSend implements Runnable{
    private final static String QUEUE_NAME = "hello";

    public void send() throws IOException, InterruptedException {
        Channel channel = RabbitMQUtils.getChannel();
        assert channel != null;
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        int count = 0;
        while (count < 20) {
            String message = "Hello World!" + count;
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_BASIC, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            count++;
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
        }
    }


    @Override
    public void run() {
        try {
            send();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@AllArgsConstructor
@Setter
class MutiRecvWork implements Runnable {
    private String name;
    private final static String QUEUE_NAME = "hello";

    @Override
    public void run() {
        Channel channel = RabbitMQUtils.getChannel();
        try {
            assert channel != null;
            channel.basicQos(1);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(name+" [x] Received '" + message + "'");
            try {
                TimeUnit.MILLISECONDS.sleep((long) (10000*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //手动应答
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };

        CancelCallback cancelCallback = consumerTag -> System.out.println("消息被中断");

        try {
            channel.basicConsume(QUEUE_NAME, false, deliverCallback, cancelCallback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
