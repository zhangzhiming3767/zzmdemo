package com.example.zzmdemo.nothingtodowithproject.lockTest.wait;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 20:27
 */
public class ThreadA extends Thread{
    public ThreadA(String name) {
        super(name);
    }
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(1000);	//	使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" call notify()");
            // 唤醒当前的wait线程
            this.notify();
        }
    }
}
