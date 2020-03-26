package com.example.zzmdemo.nothingtodowithproject.lockTest.wait;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 20:30
 */
public class ThreadB  extends Thread{
    public ThreadB(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run ");
        // 死循环，不断运行。
        while(true){;}	//	这个线程与主线程无关，无 synchronized
    }
}
