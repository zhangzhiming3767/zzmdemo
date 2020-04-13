package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/12 21:37
 */
public class RuntimeoTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        //得到系统内存的一些信息
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Java虚拟机中的空闲内存量:"+runtime.freeMemory()/1024/1024 +"MB");
        System.out.println("Java 虚拟机试图使用的最大内存量:"+ runtime.maxMemory()/1024/1024 +"MB");
        System.out.println("返回 Java 虚拟机中的内存总量:"+ runtime.totalMemory()/1024/1024 +"MB");


        //得到系统的环境变量
        Process process = Runtime.getRuntime().exec("cmd.exe /c echo %JAVA_HOME%");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String string = null;
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string); // D:\Java\jdk\jdk1.8.0_152
        }
        process.waitFor();
        System.out.println("return: " + process.exitValue()); // return: 0

        //得到java的版本号，这个和上述的不一样
        try {
            Process process2 = Runtime.getRuntime().exec("javac -version");
            BufferedReader br = new BufferedReader(new InputStreamReader(process2.getErrorStream()));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line); // javac 1.8.0_152
            }
            process2.waitFor();
            System.out.println("Process exitValue: " + process2.exitValue());
        } catch (Throwable t) {
            t.printStackTrace();
        }

        //执行外部命令
//        Process process3 = runtime.exec("C:\\Windows\\notepad.exe");//打开记事本程序，并返回一个进程
//        Thread.sleep(3000); //让当前程序停止3秒。
//        process3.destroy();
    }
}
