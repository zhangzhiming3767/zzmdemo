package com.example.zzmdemo.controller.mq.testtwo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *广播模式
 * @author zhangzhiming
 * @since 2020/4/16 19:00
 */
@Configuration
public class FanoutExchangeAndBindingConfiguration {

    /**
     * @author :zhangzhiming
     * description :
     * @date :Create in  2020/4/16 19:02
     */
    @Bean(name = "myFanoutExchange")
    FanoutExchange getFanoutExchange() {
        return new FanoutExchange("My-Fanout-Exchange");
    }

    @Bean
    Binding bindingQueueOneToFanoutExchange(@Qualifier("myFirstQueue") Queue myFirstQueue,
                                            @Qualifier("myFanoutExchange") FanoutExchange myFanoutExchange) {
        return BindingBuilder.bind(myFirstQueue).to(myFanoutExchange);
    }

    @Bean
    Binding bindingQueueTwoToFanoutExchange(@Qualifier("myTwoQueue") Queue myTwoQueue,
                                            @Qualifier("myFanoutExchange") FanoutExchange myFanoutExchange) {
        return BindingBuilder.bind(myTwoQueue).to(myFanoutExchange);
    }

    @Bean
    Binding bindingQueueThreeToFanoutExchange(@Qualifier("myThreeQueue") Queue myThreeQueue,
                                              @Qualifier("myFanoutExchange") FanoutExchange myFanoutExchange) {
        return BindingBuilder.bind(myThreeQueue).to(myFanoutExchange);
    }

}
