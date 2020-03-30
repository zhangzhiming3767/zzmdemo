package com.example.zzmdemo.system;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  定向拦截，只拦截  /user 开始的链接
 * @author zhangzhiming
 * @since 2020/3/30 15:21
 */

@Configuration
public class FilterInterceptorConfig {
    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        FilterInterceptor interceptor = new FilterInterceptor();
        registrationBean.setFilter(interceptor);
        List<String> urls = new ArrayList<>();
        urls.add("/user/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

}
