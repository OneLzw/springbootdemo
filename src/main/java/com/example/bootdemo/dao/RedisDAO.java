package com.example.bootdemo.dao;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisDAO {

    @Resource
    private StringRedisTemplate template;

    public void setKey (String key , String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key , value , 1 ,TimeUnit.MINUTES); //1分钟过期
    }

    public String getValue (String key) {
        ValueOperations<String, String> ops = template.opsForValue();
        String value = ops.get(key);
        return value;
    }
}
