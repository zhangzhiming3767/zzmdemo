package com.example.zzmdemo.nothingtodowithproject.lockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/11 17:06
 */
public class Ticket implements Runnable {
    private int tick = 1000;
    private Lock lock = new ReentrantLock();
    private static int count = 0;
    private Boolean judge = true;

    @Override
    public void run() {
        while (judge) {
            lock.lock();
            try {
                if (tick > 0) {
//                    try {
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + " 完成售票，余票为 " + --tick);
                    count++;
                } else {
                    judge = false;
                    System.out.println("最后卖了：" + count);
                }
            } finally {
                lock.unlock();
//                System.out.println("最后卖了："+count);
            }
        }
    }

//    @Override
//    public void run() {
//        while (judge) {
//            if (tick > 0) {
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " 完成售票，余票为 " + --tick);
//                count++;
//            } else {
//                judge = false;
//                System.out.println("最后卖了：" + count);
//            }
//        }
//    }
}