package com.dwp.service;

import com.dwp.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * redis业务逻辑类
 *
 * @author dengweiping
 * @date 2021/1/5 10:11
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public Result read(String key) {
        String value = redisTemplate.opsForValue().get(key).toString();
        return Result.success(value);
    }

    public Result write(Map<String, Object> map) {
        for (String key : map.keySet()) {
            redisTemplate.opsForValue().set(key, map.get(key));
        }
        return Result.success();
    }
}
