package com.example.zzmdemo.controller.threadTest;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/11 14:10
 */
public class ThreadFactoryDemo2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        /*
         * 1	corePoolSize	int	核心线程池大小
         * 2	maximumPoolSize	int	最大线程池大小
         * 3	keepAliveTime	long	线程最大空闲时间
         * 4	unit	TimeUnit	时间单位
         * 5	workQueue	BlockingQueue<Runnable>	线程等待队列
         * 6	threadFactory	ThreadFactory	线程创建工厂
         * 7	handler	RejectedExecutionHandler	拒绝策略
         */
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }, new ThreadPoolExecutor.DiscardPolicy());

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), threadFactory, handler);
        // 预启动所有核心线程
        executor.prestartAllCoreThreads();
        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
//        System.in.read(); //阻塞主线程
    }

    //线程工厂  推荐自己写的原因之一是可以命名线程
    static class NameTreadFactory implements ThreadFactory {
        //AtomicInteger 原子类
        private final AtomicInteger mThreadNum = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    //拒绝策略 默认有4中，可以自己重写  创建线程数超过了最大线程数被拒绝了
    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }
        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
        }
    }

    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                //让任务执行慢点
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
