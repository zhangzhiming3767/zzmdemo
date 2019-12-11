package com.example.zzmdemo.controller.threadTest;

import java.util.concurrent.*;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/11 14:10
 */
public class ThreadFactoryDemo {
    public static class MyTask1 implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+"Thrad ID:"+Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
    * @author :zhangzhiming
    * description :
     * corePoolSize:线程池中核心线程数的最大值
     * maximumPoolSize:线程池中能拥有最多线程数
     * keepAliveTime:表示空闲线程的存活时间
     * TimeUnit:表示keepAliveTime的单位
     * workQueue:用于缓存任务的阻塞队列
     * threadFactory:指定创建线程的工厂
    * @date :Create in  2019/12/11 14:18
    */
    public static void main(String[] args){
        MyTask1 task = new MyTask1();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                System.out.println("创建线程"+t);
                return  t;
            }
        });
        for (int i = 0;i<=4;i++){
            es.submit(task);
        }
    }
}
