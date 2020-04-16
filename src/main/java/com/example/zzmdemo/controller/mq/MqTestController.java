package com.example.zzmdemo.controller.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/16 19:54
 */
@RestController
@RequestMapping("/mqTest")
public class MqTestController {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    /**
     * @author :zhangzhiming
     * description :广播模式 测试
     * @date :Create in  2020/4/16 20:08
     */
    @RequestMapping("/fanout")
    public void fanoutExchangeTest() {
        amqpTemplate.convertAndSend("My-Fanout-Exchange", "", "123");
    }

    /**
     * @author :zhangzhiming
     * description :路由策略测试
     * @date :Create in  2020/4/16 21:17
     */
    @RequestMapping("/direct")
    public void directExchangeTest() {
        amqpTemplate.convertAndSend("My-Direct-Exchange", "routingKey.First", "123");
    }

    /**
     * @author :zhangzhiming
     * description :路由策略 可以通配的路由键 测试
     * @date :Create in  2020/4/16 21:17
     */
    @RequestMapping("/topic1")
    public void topicExchangeTest1() {
        amqpTemplate.convertAndSend("My-Topic-Exchange", "routingKey.myTest", "1");
    }

    @RequestMapping("/topic2")
    public void topicExchangeTest2() {
        amqpTemplate.convertAndSend("My-Topic-Exchange", "myTest.topic", "2");
    }

    @RequestMapping("/topic3")
    public void topicExchangeTest3() {
        amqpTemplate.convertAndSend("My-Topic-Exchange", "myTest", "3");
    }

    /**
     * @author :zhangzhiming
     * description : headers 路由策略 whereAllMap 测试
     * @date :Create in  2020/4/16 21:18
     */
    @RequestMapping("/headers1")
    public void headersExchangeTest1() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("name", "邓沙利文");
        headers.put("motto", "justry");
        rabbitMessagingTemplate.convertAndSend("My-Headers-Exchange", "", "通过[头交换机]传递数据咯", headers);
    }

    /**
     * @author :zhangzhiming
     * description : headers 路由策略 whereAnyMap 测试
     * @date :Create in  2020/4/16 21:18
     */
    @RequestMapping("/headers2")
    public void headersExchangeTest2() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("name", "邓沙利文");
        headers.put("motto", "justry123");
        rabbitMessagingTemplate.convertAndSend("My-Headers-Exchange", "", "", headers);
    }

}
