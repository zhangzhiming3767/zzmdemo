package com.example.zzmdemo.nothingtodowithproject.lockTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 售票模型
 *
 * @author zhangzhiming
 * @since 2019/12/11 14:57
 */
public class lockTest {

    public static void main(String[] args) {
//        LockTwo lockTwo=new LockTwo();
//        for (int a = 0; a < 1000; a++) {
//            Thread t = new Thread(lockTwo);
//            t.start();
//        }
//        System.out.println(lockTwo.getAccount());
        Ticket ticket = new Ticket();
        for (int a = 0; a < 50; a++) {
            new Thread(ticket, a + "号窗口").start();
        }
//        new Thread(ticket, "1号窗口").start();
//        new Thread(ticket, "2号窗口").start();
//        new Thread(ticket, "3号窗口").start();
    }
}
