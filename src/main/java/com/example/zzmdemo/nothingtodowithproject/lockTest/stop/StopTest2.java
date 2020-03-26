package com.example.zzmdemo.nothingtodowithproject.lockTest.stop;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 21:44
 */
public class StopTest2 {
    private static AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) {
        try {
            Thread t0 = new Thread(() -> {
                while (StopTest2.running.get()) {
                    System.out.println("thread->" + Thread.currentThread().getName()
                            + " run");
                }
                System.out.println("thread->" + Thread.currentThread().getName()+  " stop");
            });

            t0.start();
            Thread.sleep(1000);
            StopTest2.running.set(false);
        } catch (Throwable t) {
            System.out.println("Caught in main: " + t);
            t.printStackTrace();
        }
    }
}
