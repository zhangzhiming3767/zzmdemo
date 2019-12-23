package com.example.zzmdemo.controller.publishSubscribeTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/18 11:22
 */
public class CustomerObserver implements Observer{
    //订阅者名字
    private String name;
    private int version;

    public CustomerObserver(String name){
        this.name = name;
    }

    @Override
    public void update(int version) {
        this.version=version;
        this.buy();
    }

    public void buy(){
        System.out.println(name+"购买了第"+version+"期的杂志!");
    }

}
