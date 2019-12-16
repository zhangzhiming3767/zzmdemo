package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("/test1")
    public Response redisTest1() {
        redisTemplate.opsForValue().set("test", "测试");
        System.out.println(redisTemplate.opsForValue().get("chen"));
        System.out.println(redisTemplate.opsForValue().get("test"));
        return new ObjectResponse<>("");
    }
}
