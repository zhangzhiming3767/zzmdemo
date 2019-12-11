package com.example.zzmdemo.controller.threadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 线程池
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:22
 */
public class ExecutorsTest {
    /**
     * 线程池
     */
    private static ExecutorService executor = new ThreadPoolExecutor(10, 10,
            60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));


}
