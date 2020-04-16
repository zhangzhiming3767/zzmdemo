package com.example.zzmdemo.controller.mq.testtwo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/16 18:55
 */
@Configuration
public class QueueConfiguration {

    @Bean(name="myFirstQueue")
    public Queue getFirstQueue(){
        return new Queue("My-First-Queue");
    }

    @Bean(name="myTwoQueue")
    public Queue getTwoQueue(){
        return new Queue("My-Two-Queue");
    }

    @Bean(name="myThreeQueue")
    public Queue getThreeQueue(){
        return new Queue("My-Three-Queue");
    }
}
