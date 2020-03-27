package com.example.zzmdemo.nothingtodowithproject.lockTest.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/27 17:01
 */
public class MyRunnale implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String mark;

    public MyRunnale(CyclicBarrier cyclicBarrier, String mark) {
        super();
        this.cyclicBarrier = cyclicBarrier;
        this.mark = mark;
    }

    @Override
    public void run() {
        System.out.println(mark + "进入线程,线程阻塞中...");
        try {
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            cyclicBarrier.await();
            Thread.sleep(2000);//为了看到更好的效果，线程阻塞两秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(mark + "线程阻塞结束,继续执行...");

    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
}
