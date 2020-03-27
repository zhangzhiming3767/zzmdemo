package com.example.zzmdemo.nothingtodowithproject.lockTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/11 14:58
 */
public class SynchronizedTest implements Runnable {

    public int count=0;
    public volatile int count2=0;
    public int count3=0;
    private AtomicInteger account = new AtomicInteger(0);
    public static void main(String[] args) {
        SynchronizedTest r = new SynchronizedTest();
        for (int a = 0; a < 1000; a++) {
        Thread t = new Thread(r);
            t.start();
//            t.run();
//            try {
//                t.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }

    }
    public AtomicInteger getAccount() {
        return account;
    }

    //使用ThreadLocal类管理共享变量account
    //如果使用ThreadLocal管理变量，则每一个使用该变量的线程都获得该变量的副本，副本之间相互独立，
    // 这样每一个线程都可以随意修改自己的变量副本，而不会对其他线程产生影响。
    public static ThreadLocal<Integer> account3 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 100;
        }
    };
    public void save3(int money){
        account3.set(account3.get()+money);
    }
    public int getAccount3(){
        return account3.get();
    }

    @Override
    public void run() {
        System.out.println("111:"+(count++));
        System.out.println("222:"+(count2++));
        synchronized(this) {
//            this.notify();
            System.out.println("333:"+(count3++));
        }
//        account3.set(account3.get()+1);
//        System.out.println("444:"+(account3.get()));
        account.addAndGet(1);
        System.out.println("555:"+(account));
//            test1(0);
//            test2(1);
    }

    /**
    * @author :zhangzhiming
    * description : 不加static则synchronized不起作用
    * @date :Create in  2019/12/11 15:26
    */
    public synchronized   void test1(Integer a) {
        System.out.println(a + "进来了啦");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a + "出去了啦");
    }

    public static void test2(Integer a) {
        System.out.println(a + "进来了啦");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a + "出去了啦");
    }

}
