package com.example.zzmdemo.nothingtodowithproject.lockTest.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/27 16:40
 */
public class MyRunnable1 implements Runnable {
    private CountDownLatch countDownLatch;
    private String mark;
    public MyRunnable1(CountDownLatch countDownLatch, String mark) {
        super();
        this.countDownLatch = countDownLatch;
        this.mark = mark;
    }
    @Override
    public void run() {
        System.out.println(mark+"号线程开始");
        try {
            //使线程休眠，看到更好的测试效果
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mark+"号线程结束");
        //调用CountDownLatch的countDown方法进行次数减1
        countDownLatch.countDown();
    }
    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
}
