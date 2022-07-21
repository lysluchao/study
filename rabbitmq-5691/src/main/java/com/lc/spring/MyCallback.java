package com.lc.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 使用前需开启发布确认模式
 * spring:
 *   rabbitmq:
 *     publisher-confirm-type: correlated
 *
 *     设置为Simple时为开启单个确认
 */
@Slf4j
@Component
public class MyCallback implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //作为回调接口注入到RabbitTemplate.ConfirmCallback
    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {

    }
}
