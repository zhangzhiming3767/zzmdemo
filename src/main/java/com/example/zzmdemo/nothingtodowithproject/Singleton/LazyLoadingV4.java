package com.example.zzmdemo.nothingtodowithproject.Singleton;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *这是很多开发者推荐的一种写法，这种静态内部类方式在Singleton类被装载时并不会立即实例化，
 * 而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成对象的实例化。
 * 同时，因为类的静态属性只会在第一次加载类的时候初始化，也就保证了SingletonInstance中的对象只会被实例化一次，
 * 并且这个过程也是线程安全的。
 * @author zhangzhiming
 * @since 2020/3/27 20:54
 */
public class LazyLoadingV4 {
    private LazyLoadingV4() {}

    private static class SingletonInstance {
        private static final LazyLoadingV4 INSTANCE = new LazyLoadingV4();
    }

    public static LazyLoadingV4 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
