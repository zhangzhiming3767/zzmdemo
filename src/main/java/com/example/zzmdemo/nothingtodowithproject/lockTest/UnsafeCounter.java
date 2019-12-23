package com.example.zzmdemo.nothingtodowithproject.lockTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *           ++ 为什么不安全
 * @author zhangzhiming
 * @since 2019/12/11 16:14
 */
public class UnsafeCounter {
    public int count = 0;

    public void add() {
        count++;
    }
    public synchronized void add2() {
        count++;
    }
    public  void add3() {
        synchronized(this){
            count++;
        }
    }

    public int get() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeCounter uc = new UnsafeCounter();
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 设置 CountDownLatch 的计数器为 100，保证在主线程打印累加结果之前，100 个线程已经执行完累加
        CountDownLatch cdl = new CountDownLatch(10000);
        for(int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                uc.add3();
                // 每一个线程执行完累加操作，都将计数器减 1
                cdl.countDown();
            });
        }
        // 主线程等待，直到 cdl 的计数器为0
        cdl.await();
        System.out.println("计数器执行完100次累加后值为：" + uc.get());
    }
}
