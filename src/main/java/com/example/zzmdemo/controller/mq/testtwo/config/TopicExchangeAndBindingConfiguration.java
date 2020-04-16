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
 *  主题模式
 * @author zhangzhiming
 * @since 2020/4/16 20:49
 */
@Configuration
public class TopicExchangeAndBindingConfiguration {
    @Bean("myTopicExchange")
    TopicExchange getTopicExchange(){
        return new TopicExchange("My-Topic-Exchange");
    }

    /**
    * @author :zhangzhiming
    * description :*表示任意一个标识符；#表示零个或多个(也可以是1个)标识符。
    * @date :Create in  2020/4/16 20:57
    */
    @Bean
    Binding bindingQueueOneToTopicExchange(@Qualifier("myFirstQueue") Queue myFirstQueue,
                                           @Qualifier("myTopicExchange") TopicExchange myTopicExchange) {
        return BindingBuilder.bind(myFirstQueue).to(myTopicExchange).with("routingKey.#");
    }
    @Bean
    Binding bindingQueueTwoToTopicExchange(@Qualifier("myTwoQueue") Queue myTwoQueue,
                                           @Qualifier("myTopicExchange") TopicExchange myTopicExchange) {
        return BindingBuilder.bind(myTwoQueue).to(myTopicExchange).with("#.topic");
    }
    @Bean
    Binding bindingQueueThreeToTopicExchange(@Qualifier("myThreeQueue") Queue myThreeQueue,
                                           @Qualifier("myTopicExchange") TopicExchange myTopicExchange) {
        return BindingBuilder.bind(myThreeQueue).to(myTopicExchange).with("#");
    }
}
