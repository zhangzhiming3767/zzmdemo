package com.example.zzmdemo.controller.JavaBaseTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangzhiming
 * description
 * @date 17:28 2019/10/10
 */
public class OtherTestController {

    public static void main(String[] args) {
//        lambdaTest();
//        asyncTest();
        forTest();
        forTest2();
    }

     /**
      * @author zhangzhiming
      * description 测一下   大循环写在内, 小循环写在外 两种写法的区别  抽空用多线程试试
      * @date 17:29 2019/10/10
      */
     private static void forTest(){
         SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
         int count=0;
         System.out.println("开始时间1："+date.format(new Date(System.currentTimeMillis())));
         for(int a=0;a<2147483647;a++){
             for(int b=0;b<21474836;b++){
                 count++;
             }
         }
         System.out.println("结束时间1："+count+" "+date.format(new Date(System.currentTimeMillis())));
     }

    private static void forTest2(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
        int count=0;
        System.out.println("开始时间2："+date.format(new Date(System.currentTimeMillis())));
        for(int a=0;a<21474836;a++){
            for(int b=0;b<2147483647;b++){
                count++;
            }
        }
        System.out.println("结束时间2："+count+" "+date.format(new Date(System.currentTimeMillis())));
    }
}
