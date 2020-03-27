package com.example.zzmdemo.nothingtodowithproject.lockTest.servenMethod;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 11:34
 */
public class MybanRunnable implements Runnable{
    private Bank bank;

    public MybanRunnable(Bank bank) {
        this.bank = bank;
    }


    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            bank.save1(1);
            System.out.println("账户11111余额是---"+bank.getAccount());
            bank.save2(1);
            System.out.println("账户2222余额是---"+bank.getAccount2());
            bank.save3(1);
            System.out.println("账户2222余额是---"+bank.getAccount3());
        }

    }

}
