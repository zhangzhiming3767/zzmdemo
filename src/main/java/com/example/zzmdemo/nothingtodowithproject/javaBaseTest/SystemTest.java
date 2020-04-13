package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/13 17:09
 */
public class SystemTest {

    public static void main(String[] args){
//        System.gc();
        System.out.println("currentTimeMillis() "+System.currentTimeMillis());
//        System.out.println("这是控制台输入的内容：  "+System.console().readLine());
        boolean end=true;
        System.out.println("开始，输入1结束");
        while (end){
            Scanner in = new Scanner(System.in);
            String content=in.next();
            System.out.println("输入内容： "+content);
            if(Objects.equals("1",content)){
                end=false;
                System.out.println("结束了");
            }
        }
        int[] srcArr = {10,12,14,16,19};
        //把srcArr的数组元素拷贝 到destArr数组中。
        int[] destArr = new int[4];
        //该方法进行数组拷贝
        System.arraycopy(srcArr, 2, destArr, 1, 2);
        System.out.println("目标数组的元素："+Arrays.toString(destArr));
        //该方法用来根据环境变量的名字获取环境变量
        System.out.println("环境变量："+System.getenv("path"));
        //获取系统的所有属性
        Properties properties = System.getProperties();
        properties.list(System.out);
    }
}
