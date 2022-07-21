package com.lc.redis.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

/**
 * 延时队列
 *
 * @param <T>
 */
public class RedisDelayingQueue<T> {
    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    private Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();


    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private String queueKey;

    public RedisDelayingQueue(String queueKey) {
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<T>();
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        String s = JSON.toJSONString(task);
        redisTemplate.opsForZSet().add(queueKey, s, System.currentTimeMillis() + 5000);
    }

    public void loop() {
        while (!Thread.interrupted()) {
            Set<String> values = redisTemplate.opsForZSet().rangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String s = values.iterator().next();

            if (redisTemplate.opsForZSet().remove(queueKey, s) > 0) {
                TaskItem<T> task = JSON.parseObject(s, TaskType);
                this.handleMsg(task.msg);
            }
        }
    }

    private void handleMsg(T msg) {
        System.out.println(msg);
    }
}
