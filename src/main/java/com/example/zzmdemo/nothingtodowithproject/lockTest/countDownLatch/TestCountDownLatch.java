package com.example.zzmdemo.nothingtodowithproject.lockTest.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *CountDownLatch典型用法1：某一线程在开始运行前等待n个线程执行完毕。将CountDownLatch的计数器初始化为n new CountDownLatch(n) ，
 * 每当一个任务线程执行完毕，就将计数器减1 countdownlatch.countDown()，当计数器的值变为0时，在CountDownLatch上 await() 的线程就会被唤醒。
 * 一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。
 * @author zhangzhiming
 * @since 2020/3/27 16:38
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Executor executor = Executors.newFixedThreadPool(5);
        //测试阻塞其他线程
//        new Thread(new MyRunnable(countDownLatch)).start();
//        //为了测试效果进行线程休眠
//        Thread.sleep(1000);
//        for(int i = 1;i<=5;i++){
//            countDownLatch.countDown();
//            System.out.println("第"+i+"调用countDown方法结束");
//            //为了测试效果进行线程休眠
//            Thread.sleep(1000);
//        }
        /**
         * 测试阻塞主线程
         */
		for (int i = 1; i <= 5; i++) {
			new Thread(new MyRunnable1(countDownLatch,i+"")).start();
			Thread.sleep(1000);
		}
		try {
			System.out.println("主线程阻塞");
			countDownLatch.await();
			System.out.println("主线程继续执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
