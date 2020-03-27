package com.example.zzmdemo.nothingtodowithproject.lockTest;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *用阻塞队列实现线程同步 LinkedBlockingQueue的使用
 *  * 实现商家生产商品和买卖商品的同步
 * @author zhangzhiming
 * @since 2020/3/27 15:57
 */
public class BlockingSynchronizedThread {
    /**
     * 定义一个阻塞队列用来存储生产出来的商品
     */
    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    /**
     * 定义生产商品个数
     */
    private static final int size = 10;
    /**
     * 定义启动线程的标志，为0时，启动生产商品的线程；为1时，启动消费商品的线程
     */
    private int flag = 0;

    private class LinkBlockThread implements Runnable {
        @Override
        public void run() {
            int new_flag = flag++;
            System.out.println("启动线程 " + new_flag);
            if (new_flag%2 == 0) {
                for (int i = 0; i < size; i++) {
                    int b = new Random().nextInt(255);
                    System.out.println("生产商品：" + b + "号");
                    try {
                        queue.put(b);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("仓库中还有商品：" + queue.size() + "个");
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                }
            } else {
//                for (int i = 0; i < size / 2; i++) {
                for (int i = 0; i < size; i++) {
                    try {
                        int n = queue.take();
                        System.out.println("消费者买去了" + n + "号商品");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("仓库中还有商品：" + queue.size() + "个");
//                    try {
//                        Thread.sleep(100);
//                    } catch (Exception e) {
//                        // TODO: handle exception
//                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingSynchronizedThread bst = new BlockingSynchronizedThread();
        LinkBlockThread lbt = bst.new LinkBlockThread();
        for(int i=0;i<100;i++){
            Thread thread1 = new Thread(lbt);
            thread1.start();
        }
//        Thread thread1 = new Thread(lbt);
//        Thread thread2 = new Thread(lbt);
//        thread1.start();
//        thread2.start();

    }

}
