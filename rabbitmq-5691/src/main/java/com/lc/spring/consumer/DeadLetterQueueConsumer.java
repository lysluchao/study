package com.lc.spring.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {
    @RabbitListener(queues = "QDEAD")
    public void receiveD(Message message, Channel channel) {
        String msg = new String(message.getBody());
        log.info("当前时间：{}，收到死信队列的消息：{}", new Date(), msg);

    }
}
