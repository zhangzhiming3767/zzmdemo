package com.example.zzmdemo.controller.mq.testtwo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *路由策略
 * @author zhangzhiming
 * @since 2020/4/16 20:24
 */
@Configuration
public class DirectExchangeAndBindingConfiguration {
    @Bean(name = "myDirectExchange")
    DirectExchange getDirectExchange() {
        return new DirectExchange("My-Direct-Exchange");
    }

    @Bean
    Binding bindingQueueOneToDirectExchange(@Qualifier("myFirstQueue") Queue myFirstQueue,
                                            @Qualifier("myDirectExchange") DirectExchange myDirectExchange) {
        return BindingBuilder.bind(myFirstQueue).to(myDirectExchange).with("routingKey.First");
    }
}
