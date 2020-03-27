package com.example.zzmdemo.nothingtodowithproject.Singleton;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *这是懒汉式中最简单的一种写法，只有在方法第一次被访问时才会实例化，达到了懒加载的效果。
 * 但是这种写法有个致命的问题，就是多线程的安全问题。假设对象还没被实例化，然后有两个线程同时访问，
 * 那么就可能出现多次实例化的结果，所以这种写法不可采用。
 * @author zhangzhiming
 * @since 2020/3/27 20:45
 */
public class LazyLoadingV1 {
    private static LazyLoadingV1 instance = null;

    private LazyLoadingV1() {
    }

    public static LazyLoadingV1 getInstance() {
        if (instance == null) {
            instance = new LazyLoadingV1();
        }
        return instance;
    }

}
