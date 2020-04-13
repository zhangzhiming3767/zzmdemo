package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.util.Random;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/12 21:21
 */
public class RandomTest {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            System.out.println("Math "+ (int)(Math.random() * 100));
        }
        //使用默认当前系统时间的毫秒数作为种子数
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            System.out.println("random1 "+ random.nextInt(100));
        }
        //使用自己指定的种子数  这是一种伪随机  每次运行程序，打印结果一致
        Random random2 = new Random(100);
        for(int i = 0; i < 5; i++){
            System.out.println("random2 "+ random2.nextInt(10));
        }
        Random random3 = new Random();
        for(int i = 0; i < 3; i++){
            System.out.println("random3 "+ (int)(random3.nextDouble()*100));
        }
    }
}
