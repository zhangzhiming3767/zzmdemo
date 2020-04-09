package com.example.zzmdemo.controller.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/5 14:57
 */
@Component
public class Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;
    public void send() {
        String message =  "message" + new Date();
        System.out.println("Sender  " + message);
        rabbitTemplate.convertAndSend("immediate_exchange_test1", "immediate_routing_key_test1", message);
    }

}
