package com.lc.confirm;

import com.lc.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class PublishConfirm {
    private static final String QUEUE_NAME="publish_confirm_queue";
    private static final int MESSAGE_NUMBER = 1000;

    /**
     * 单个发布确认
     */
    public static void publishComfirmIndividually() throws Exception {

        Channel channel = RabbitMQUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        /*
          开启发布确认
          一旦模式开启，会为channel内的每一条消息，都配置上一个为一个的ID或者是标签名
         */
        channel.confirmSelect();

        long start = System.currentTimeMillis();
        for (int i = 1; i <= MESSAGE_NUMBER; i++) {
            boolean flag = false;
            String message = "消息: " + i;
            flag = sendMessage(message, channel);
            while (!flag) {
                flag = sendMessage(message, channel);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_NUMBER + "条消息，耗时：" + (end - start) + "ms");
    }

    public static boolean sendMessage(String message, Channel channel) throws Exception {
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        //等待确认
        return channel.waitForConfirms();
    }

    /**
     * 异步发布确认
     */
    public static void publishComfirmAsync() throws Exception {

        Channel channel = RabbitMQUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        /*
          开启发布确认
          一旦模式开启，会为channel内的每一条消息，都配置上一个为一个的ID或者是标签名或者是消息唯一的序列号
         */
        channel.confirmSelect();


        /*
          什么是concurrentSkipListMap
          线程安全有序的一个哈希表，适用于高并发的情况
          1. 轻松的将序号和消息关联、
          2、轻松的批量删除条目，只需要给出序号
          3、支持并发访问
         */
        //ConcurrentLinkedQueue
        ConcurrentSkipListMap<Long, String> unconfirmedMessageMap = new ConcurrentSkipListMap<>();


        /*
          确认收到一个消息的回调
          1. 发送的消息标志号，消息序列号
          2. true 可以确认小于等于当前序列号的消息（批量确认下）
             false 确认当前序列号的消息
         */
        ConfirmCallback ackCallback = (deliverTag,multiple)->{
            if(multiple){
                //返回的是小于等于当前序列号的未确认消息 是一个 map
                ConcurrentNavigableMap<Long, String> confirmedMap = unconfirmedMessageMap.headMap(deliverTag,true);
                //清除该部分未确认消息
                confirmedMap.clear();
            }else{
                // 移除当前确认的 消息序号
                unconfirmedMessageMap.remove(deliverTag);
            }
        };

        // broker未收到消息的回调
        ConfirmCallback nackCallback = (deliverTag, multiple)->{
            // 通过 未被broker确认的消息序列号deliverTag，获取
            String message = unconfirmedMessageMap.get(deliverTag);
            System.out.println("未被broker确认的消息："+message);
        };

        // 为channel 增加发布确认监听器
        channel.addConfirmListener(ackCallback,nackCallback);

        long start = System.currentTimeMillis();
        for (int i = 1; i <= MESSAGE_NUMBER; i++) {
            String message = "消息: " + i;
            // getNextPublishSeqNo 返回下一个要被发布消息的序列号
            unconfirmedMessageMap.put(channel.getNextPublishSeqNo(),message);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_NUMBER + "条消息，耗时：" + (end - start) + "ms");
    }

    /**
     * 批量发布确认
     */
    public static void publishComfirmBatch() throws Exception {

        Channel channel = RabbitMQUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        /**
         * 开启发布确认
         * 一旦模式开启，会为channel内的每一条消息，都配置上一个为一个的ID或者是标签名
         */
        channel.confirmSelect();
        // 批量确认消息的 大小
        int batchSize = 100;
        // 为确认消息的个数
        int unconfirmedCount = 0;

        long start = System.currentTimeMillis();
        for (int i = 1; i <= MESSAGE_NUMBER; i++) {
            String message = "消息: " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            unconfirmedCount++;
            // 如果为确认的消息个数达到 指定的批量确认的条件,进行等待确认，要求broker给与确认
            if(unconfirmedCount == batchSize){
                boolean flag = channel.waitForConfirms();
                if(!flag){
                    System.out.println("有确认失败的消息,但不知道是哪个");
                }
                unconfirmedCount = 0;
            }
        }

        //还有未被确认的，等待确认
        if(unconfirmedCount > 0){
            channel.waitForConfirms();
        }

        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_NUMBER + "条消息，耗时：" + (end - start) + "ms");
    }

    public static void main(String[] args) throws Exception {
        publishComfirmIndividually();
        publishComfirmBatch();
        publishComfirmAsync();
    }

}
