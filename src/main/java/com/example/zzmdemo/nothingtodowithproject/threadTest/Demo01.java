package com.example.zzmdemo.nothingtodowithproject.threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/10 19:10
 */
public class Demo01 {
    public static void main(String[] args) {

        Call call = new Call();
        FutureTask<Integer> futureTask = new FutureTask<>(call);
        Thread thread=new Thread(futureTask);
        thread.run();
        int sum = 1;
        try {
            sum = futureTask.get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }
        System.out.println(sum);

    }
}
