package com.example.zzmdemo.nothingtodowithproject;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 查看内存使用情况
 * @author zhangzhiming
 * @since 2020/3/30 16:54
 */
public class QryMemory {

    public static void main(String[] args){
        OperatingSystemMXBean osmb = ManagementFactory.getOperatingSystemMXBean();
        double size = osmb.getSystemLoadAverage();
        System.out.println("size:"+size/1024/1024+"M");
        Runtime runtime=Runtime.getRuntime();
        long maxMemory=runtime.maxMemory();
        long freeMemory=runtime.freeMemory();
        long totalMemory=runtime.totalMemory();
        System.out.println("可以获得的最大内存:"+maxMemory/1024/1024+"M");
        System.out.println("剩余:"+freeMemory/1024/1024+"M");
        System.out.println("已分配:"+totalMemory/1024/1024+"M");
        File file = new File("D:");
        long totalSpace = file.getTotalSpace();
        long freeSpace = file.getFreeSpace();
        long usedSpace = totalSpace - freeSpace;
        System.out.println("总空间大小 : " + totalSpace / 1024 / 1024 / 1024 + "G");
        System.out.println("剩余空间大小 : " + freeSpace / 1024 / 1024 / 1024 + "G");
        System.out.println("已用空间大小 : " + usedSpace / 1024 / 1024 / 1024 + "G");
    }

}
