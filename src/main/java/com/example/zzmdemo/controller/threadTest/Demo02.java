package com.example.zzmdemo.controller.threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:11
 */
public class Demo02 {
    public static void main(String[] args) {
        Call call = new Call();
        FutureTask<Integer> futureTask1 = new FutureTask<>(call);
        FutureTask<Integer> futureTask2 = new FutureTask<>(call);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(futureTask1);
        executor.submit(futureTask2);
        try {
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
