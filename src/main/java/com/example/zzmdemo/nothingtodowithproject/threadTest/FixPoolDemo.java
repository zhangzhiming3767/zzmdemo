package com.example.zzmdemo.nothingtodowithproject.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:28
 */
public class FixPoolDemo {
    private static Runnable getThread(final int i) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
    }

    public static void main(String args[]) {
        test2();
    }

    public static void test1(){
        ExecutorService fixPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            fixPool.execute(getThread(i));
        }
        fixPool.shutdown();
    }
    public static void test2(){
        ExecutorService cachePool = Executors.newCachedThreadPool();
        for (int i=1;i<=10;i++){
            cachePool.execute(getThread(i));
        }
    }
}
