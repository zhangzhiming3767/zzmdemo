package com.example.zzmdemo.controller.threadTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:21
 */
public class Demo03 {
    public static void main(String[] args) {
        RunnableThread d = new RunnableThread("Demo");
        Thread t = new Thread(d);
        Thread t2 = new Thread(d);
        t.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + "***");//主线程一开始就执行了一次，然后就不执行了。
    }
}
