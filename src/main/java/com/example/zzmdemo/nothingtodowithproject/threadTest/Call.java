package com.example.zzmdemo.nothingtodowithproject.threadTest;

import java.util.concurrent.Callable;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:09
 */
public class Call implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int num = 0;
        System.out.println("这里是Call的call方法!");
        return num;
    }

}
