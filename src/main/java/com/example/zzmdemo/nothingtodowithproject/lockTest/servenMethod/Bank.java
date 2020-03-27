package com.example.zzmdemo.nothingtodowithproject.lockTest.servenMethod;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 11:35
 */
public class Bank {
    private int account = 1;
    private int account2 = 1;
    public int getAccount() {
        return account;
    }
    public int getAccount2() {
        return account2;
    }
    //同步方法
    public synchronized void save(int money) {
        account+=money;
    }

    public void save1(int money) {
        //同步代码块
        synchronized(this) {
            account+=money;
        }
    }
    public void save2(int money) {
        account2+=money;
    }
    //使用ThreadLocal类管理共享变量account
    private static ThreadLocal<Integer> account3 = new ThreadLocal<Integer>(){
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


    public void userThread() {
        Bank bank = new Bank();
        MybanRunnable my1 = new MybanRunnable(bank);
        for(int i=0;i<100;i++){
            System.out.println("线程"+i);
            Thread th1 = new Thread(my1);
            th1.start();
        }

    }

}
