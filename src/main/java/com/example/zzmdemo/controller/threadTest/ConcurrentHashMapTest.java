package com.example.zzmdemo.controller.threadTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * ConcurrentHashMap是绝对线程安全的嘛
 * 在step1跟step2中，都只是调用ConcurrentHashMap的方法，各自都是原子操作，是线程安全的。但是他们组合在一起的时候就会有问题了，
 * A线程在进入方法后，通过map.get("key")拿到key的值，刚把这个值读取出来还没有加1的时候，线程B也进来了，
 * 那么这导致线程A和线程B拿到的key是一样的。不仅仅是在
 * ConcurrentHashMap，在其他的线程安全的容器比如Vector之类的也会出现如此情况，所以在使用这些容器的时候还是不能大意。
 * 如何解决？
 * 1、可以用synchronized
 * 2、用原子类
 *
 * @author zhangzhiming
 * @since 2019/12/12 16:56
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }


    public static void test1() throws InterruptedException {
        //下面这种  用Integer是有线程安全问题的
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("key", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch cdl = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //step 1
                    int key = map.get("key") + 1;
                    //step 2
                    map.put("key", key);
                    cdl.countDown();
                }
            });
        }
//        Thread.sleep(3000); //模拟等待执行结束
        // 主线程等待，直到 cdl 的计数器为0
        cdl.await();
        System.out.println("1------" + map.get("key") + "------");
        executorService.shutdown();
    }

    public static void test2() throws InterruptedException {
        //用原子类避免线程安全问题
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
        AtomicInteger integer = new AtomicInteger(1);
        map.put("key", integer);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch cdl = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    map.get("key").incrementAndGet();
                    cdl.countDown();
                }
            });
        }
//        Thread.sleep(3000); //模拟等待执行结束
        // 主线程等待，直到 cdl 的计数器为0
        cdl.await();
        System.out.println("2------" + map.get("key") + "------");
        executorService.shutdown();
    }
}
