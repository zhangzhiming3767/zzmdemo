package com.example.zzmdemo.nothingtodowithproject.lockTest.stop;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 21:31
 */
public class StopTest {
    public static void main(String[] args) {
        final Object lock = new Object();

        try {
            Thread t0 = new Thread(() -> {
                try {
                    synchronized (lock) {
                        System.out.println("thread->" + Thread.currentThread().getName()
                                + " acquire lock.");
                        // sleep for 3s
                        Thread.sleep(3000);
                        System.out.println("thread->" + Thread.currentThread().getName()
                                + " release lock.");
                    }
                } catch (Throwable ex) {
                    System.out.println("Caught in run: " + ex);
                    ex.printStackTrace();
                }
            });

            Thread t1 = new Thread(() -> {
                synchronized (lock) {
                    System.out.println("thread->" + Thread.currentThread().getName()
                            + " acquire lock.");
                }
            });

            t0.start();
            //这两句放开会导致报错，来证明stop被舍弃的原因
//            Thread.sleep(1000);
//            t0.stop();
            t1.start();
        } catch (Throwable e) {
            System.out.println("Caught in main: " + e);
            e.printStackTrace();
        }
    }
}
