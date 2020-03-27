package com.example.zzmdemo.nothingtodowithproject.lockTest.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/27 16:40
 */
public class MyRunnable implements Runnable {
    CountDownLatch countDownLatch;
    public MyRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println("进入线程，即将进入阻塞状态");
            //调用await进行线程阻塞
            countDownLatch.await();
            System.out.println("线程进行执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

