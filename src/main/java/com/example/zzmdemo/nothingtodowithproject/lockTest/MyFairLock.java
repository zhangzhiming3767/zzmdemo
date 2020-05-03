package com.example.zzmdemo.nothingtodowithproject.lockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  公平锁
 * @author zhangzhiming
 * @since 2020/5/3 22:56
 */
public class MyFairLock {
    /**
     * true 表示 ReentrantLock 的公平锁
     */
    private ReentrantLock lock = new ReentrantLock(true);

    public void testFail() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyFairLock fairLock = new MyFairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairLock.testFail();
        };
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
