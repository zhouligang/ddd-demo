package com.qdsg.his.infrastructure.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author zhouligang
 * @Date 2023/3/6 13:51
 * @Desc
 */
@Service
public class RedisService {
    private RedisTemplate redisTemplate;

    public RedisService(RedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
    }
}
