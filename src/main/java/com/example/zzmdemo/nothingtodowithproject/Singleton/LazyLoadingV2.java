package com.example.zzmdemo.nothingtodowithproject.Singleton;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *这种写法是对getInstance()加了锁的处理，保证了同一时刻只能有一个线程访问并获得实例，
 * 但是缺点也很明显，因为synchronized是修饰整个方法，每个线程访问都要进行同步，
 * 而其实这个方法只执行一次实例化代码就够了，每次都同步方法显然效率低下，为了改进这种写法，就有了下面的双重检查懒汉式。
 * @author zhangzhiming
 * @since 2020/3/27 20:47
 */
public class LazyLoadingV2 {
    private static LazyLoadingV2 instance = null;

    private LazyLoadingV2() {
    }

    public static synchronized LazyLoadingV2 getInstance() {
        if (instance == null) {
            instance = new LazyLoadingV2();
        }
        return instance;
    }
}
