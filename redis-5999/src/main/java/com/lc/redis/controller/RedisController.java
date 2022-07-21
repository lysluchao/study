package com.lc.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/redis/set/{key}/{value}")
    public void set(@PathVariable("key") String key,@PathVariable("value") String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @PostMapping("/redis/put/{key}")
    public String get(@PathVariable("key") String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
