package com.example.zzmdemo.nothingtodowithproject.lockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 21:58
 */
public class LockTwo implements Runnable{
    private int account = 100;
    private ReentrantLock lock = new ReentrantLock();
    public int getAccount() {
        return account;
    }
    //同步方法
    @Override
    public  void run() {
        lock.lock();
        try {
            account++;
        } finally {
            lock.unlock();
        }

//         account++;

    }
}
