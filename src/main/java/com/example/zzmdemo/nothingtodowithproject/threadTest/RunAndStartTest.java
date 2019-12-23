package com.example.zzmdemo.nothingtodowithproject.threadTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * run 与start的区别测试
 *
 * @author zhangzhiming
 * @since 2019/12/11 14:47
 */
public class RunAndStartTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Hello");
    }

    public static void main(String[] args) {
        runTest();
    }

    /**
    * @author :zhangzhiming
    * description :用start()来启动线程，实现了真正意义上的启动线程，此时会出现异步执行的效果，即在线程的创建和启动中所述的随机性。‘
     * 而如果使用run()来启动线程，就不是异步执行了，而是同步执行，不会达到使用线程的意义。
    * @date :Create in  2019/12/11 14:50
    */
    public static void startTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println("创建一个线程");
            RunAndStartTest r = new RunAndStartTest();
            Thread t = new Thread(r);
            System.out.println("启动线程");
            t.start();
        }
    }
    
    private static void runTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println("创建一个线程");
            RunAndStartTest r = new RunAndStartTest();
            Thread t = new Thread(r);
            System.out.println("启动线程");
            t.run();
        }
    }
}
