package com.example.zzmdemo.nothingtodowithproject.Singleton;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *这种写法用了两个if判断，也就是Double-Check，并且同步的不是方法，
 * 而是代码块，效率较高，是对第三种写法的改进。为什么要做两次判断呢？
 * 这是为了线程安全考虑，还是那个场景，对象还没实例化，两个线程A和B同时访问静态方法并同时运行到第一个if判断语句，
 * 这时线程A先进入同步代码块中实例化对象，结束之后线程B也进入同步代码块，
 * 如果没有第二个if判断语句，那么线程B也同样会执行实例化对象的操作了。
 * @author zhangzhiming
 * @since 2020/3/27 20:49
 */
public class LazyLoadingV3 {
    private static volatile LazyLoadingV3 instance;

    private LazyLoadingV3() {
    }

    public static LazyLoadingV3 getInstance() {
        if (instance == null) {
            synchronized (LazyLoadingV3.class) {
                if (instance == null) {
                    instance = new LazyLoadingV3();
                }
            }
        }
        return instance;
    }
}
