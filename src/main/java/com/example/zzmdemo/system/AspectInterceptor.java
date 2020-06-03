package com.example.zzmdemo.system;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/30 15:40
 */

@Aspect
@Component
public class AspectInterceptor {

    @Around("execution(* com.example.zzmdemo.controller.user.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint point) throws Throwable {
        System.out.println("aspect 拦截开始");
        long start = System.currentTimeMillis();
        Object[] args = point.getArgs();
        for (Object obj : args) {
            System.out.println("arg is:" + obj);
        }
        //具体方法的返回值
        Object obj = point.proceed();
        System.out.println("aspect 拦截结束  耗时：" + (System.currentTimeMillis() - start));
        return obj;
    }
}
