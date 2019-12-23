package com.example.zzmdemo.nothingtodowithproject.threadTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangzhiming
 * description 多线程测试
 * @date 18:59 2019/10/30
 */
@RestController
@RequestMapping("/thread")
public class ThreadTest {
    class SaleTickets extends Thread {
        private int tickets = 500;
        @Override
        public void run() {
            while (true) {
                if (tickets > 0) {
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "还剩" + tickets + "张票");
                    if (tickets == 0) {
                        break;
                    }
                }
            }
        }
    }

    @RequestMapping("/test")
    public void test() {
        SaleTickets st = new SaleTickets();
        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");
        Thread t4 = new Thread(st, "窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    public  class Exemple{
        private int cnt=0;
        //synchronized  加与不加
        public  synchronized  void add(){
            cnt++;
        }
        public  int res(){
            return cnt;
        }
    }
    public static void main(String[]args)throws InterruptedException{
        int threadSize=1000;
        ThreadTest e=new ThreadTest();
        Exemple exemple=e.new Exemple();
        CountDownLatch countDownLatch=new CountDownLatch(threadSize);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<threadSize;i++){
            executorService.execute(()->{
                        exemple.add();
//                System.out.println(exemple.res());
                    }
            );
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(exemple.res());
    }

}
