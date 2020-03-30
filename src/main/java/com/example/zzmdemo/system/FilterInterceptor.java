package com.example.zzmdemo.system;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;


/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/30 15:08
 */
@Component
public class FilterInterceptor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第一种filter拦截，开始");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("第一种filter拦截 结束，耗时："+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
