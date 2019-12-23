package com.example.zzmdemo.nothingtodowithproject.threadTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:19
 */
public class RunnableThread implements Runnable {
    private String name;

    public RunnableThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(name + ".." + Thread.currentThread().getName() + ".." + i);
        }
    }
}
