package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *    需要一个工具类来展示redis常用方法
 * @author zhangzhiming
 * @since 2019/12/16 16:49
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    private RedisTemplate redisTemplate;
    private static final String REDIS_BIZNO = "bizNo";
    private static final int START_NUMBER = 10000;
    private static final Integer MAX_NUMBER = 10010;
    @PostMapping("/test1")
    public Response redisTest1() {
        redisTemplate.opsForValue().set("test", "测试");
        Integer test=(Integer)redisTemplate.opsForValue().get("chen");
        System.out.println(redisTemplate.opsForValue().get("chen"));
        System.out.println(redisTemplate.opsForValue().get("test"));
        return new ObjectResponse<>("");
    }

    @PostMapping("/test2")
    public synchronized int redisTest2(String name) {
        try {
            if(StringUtils.isNotEmpty(name)){
                throw new RuntimeException();
            }
            Integer result = (Integer) redisTemplate.opsForValue().get(REDIS_BIZNO);
            if (result == null || MAX_NUMBER.equals(result)) {
                result = START_NUMBER;
            }
            redisTemplate.opsForValue().set(REDIS_BIZNO, result + 1);
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    @PostMapping("/test4")
    public  String redisTest4(String name) {
        String now=DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now());
        int number=redisTest2("");
        if(number==0){
            throw new RuntimeException();
        }
        return now+number;
    }

    @PostMapping("/test3")
    public  int redisTest3(String name) {
        redisTemplate.delete(REDIS_BIZNO);
        return 0;
    }
}
