package com.example.zzmdemo.controller.mq.testtwo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/16 21:03
 */
@Configuration
public class HeadersExchangeAndBindingConfiguration {
    @Bean(name = "myHeadersExchange")
    HeadersExchange geHeadersExchange() {
        return new HeadersExchange("My-Headers-Exchange");
    }

    @Bean
    Binding bindingQueueOneToHeadersAllExchange(@Qualifier("myFirstQueue") Queue myFirstQueue,
                                            @Qualifier("myHeadersExchange") HeadersExchange myHeadersExchange) {
        Map<String,Object> headers=new HashMap<>();
        headers.put("name","邓沙利文");
        headers.put("motto","justry");
        return BindingBuilder.bind(myFirstQueue).to(myHeadersExchange).whereAll(headers).match();
    }
    @Bean
    Binding bindingQueueOneToHeadersAnyExchange(@Qualifier("myThreeQueue") Queue myThreeQueue,
                                                @Qualifier("myHeadersExchange") HeadersExchange myHeadersExchange) {
        Map<String,Object> headers=new HashMap<>();
        headers.put("name","邓沙利文");
        headers.put("motto","justry");
        return BindingBuilder.bind(myThreeQueue).to(myHeadersExchange).whereAny(headers).match();
    }
}
