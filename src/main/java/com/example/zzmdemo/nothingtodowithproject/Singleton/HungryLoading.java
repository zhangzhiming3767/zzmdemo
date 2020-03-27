package com.example.zzmdemo.nothingtodowithproject.Singleton;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *饿汉式
 * 这是比较常见的写法，在类加载的时候就完成了实例化，避免了多线程的同步问题。
 * 当然缺点也是有的，因为类加载时就实例化了，没有达到Lazy Loading (懒加载) 的效果，
 * 如果该实例没被使用，内存就浪费了。
 * @author zhangzhiming
 * @since 2020/3/27 20:52
 */
public class HungryLoading {
    private final static HungryLoading INSTANCE = new HungryLoading();

    private HungryLoading() {
    }

    public static HungryLoading getInstance() {
        return INSTANCE;
    }
}
