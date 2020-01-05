package com.example.zzmdemo.nothingtodowithproject.lockTest;

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

    public static void main(String[] args) {
        SynchronizedTest r = new SynchronizedTest();
        for (int a = 0; a < 3000; a++) {
        Thread t = new Thread(r);
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println(count++);
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