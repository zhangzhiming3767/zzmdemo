package com.example.zzmdemo.controller.mq.testtwo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/16 19:13
 */
@Component
public class DemoMessageListener {

    @RabbitListener(queues = "My-First-Queue")
    public void firstConsumer(String string){
        System.out.println("我是：My-First-Queue"+"\tString:"+string);
    }
    @RabbitListener(queues = "My-Two-Queue")
    public void twoConsumer(Integer num){

        System.out.println("我是：My-Two-Queue"+"\tInteger:"+num);
    }
    @RabbitListener(queues = "My-Three-Queue")
    public void threeConsumer(){
        System.out.println("我是：My-Three-Queue");
    }
}
