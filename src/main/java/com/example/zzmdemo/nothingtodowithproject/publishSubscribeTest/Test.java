package com.example.zzmdemo.nothingtodowithproject.publishSubscribeTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *观察者模式又称为发布/订阅(Publish/Subscribe)模式
 *
 * 观察者设计模式涉及到两种角色：主题（Subject）和观察者（Observer）
 * @author zhangzhiming
 * @since 2019/12/18 11:25
 */
public class Test {
    public static void main(String[] args) {
        //创建主题(被观察者)
        MagazineSubject magazine = new MagazineSubject();
        //创建三个不同的观察者
        CustomerObserver a = new CustomerObserver("A");
        CustomerObserver b = new CustomerObserver("B");
        CustomerObserver c = new CustomerObserver("C");
        //将观察者注册到主题中
        magazine.addObserver(a);
        magazine.addObserver(b);
        magazine.addObserver(c);

        //更新主题的数据，当数据更新后，会自动通知所有已注册的观察者
        magazine.publish();
        magazine.deleteObserver(a);
        magazine.deleteObserver(b);
        magazine.publish();
    }
}
