package com.example.zzmdemo.nothingtodowithproject.publishSubscribeTest;


import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/18 11:17
 */
public class MagazineSubject implements Subject {
    //存放订阅者
    private List<Observer> observers=new ArrayList<Observer>();
    //期刊版本
    private int version;

    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(o->o.update(version));
//        for(int i=0;i<observers.size();i++){
//            Observer o=observers.get(i);
//            o.update(version);
//        }
    }

    //该杂志发行了新版本
    public synchronized void publish(){
        System.out.println("该杂志出新版本了");
        //新版本
        this.version++;
        //信息更新完毕，通知所有观察者
        notifyObserver();
    }
}
