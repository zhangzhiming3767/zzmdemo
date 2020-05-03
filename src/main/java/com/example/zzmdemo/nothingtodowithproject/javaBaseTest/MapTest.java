package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.util.HashMap;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/29 14:15
 */
public class MapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        HashMap<String,String> test=new HashMap<>(100);
        int result=tableSizeFor(23);
        System.out.println("");
//        paramTest(null);
        // 0000 0101
        int a = 5;
        // 0000 0011
        int b = 3;
        // 0000 0111
        a |= b;
        System.out.println(a);

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        //按位或后赋值
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    void paramTest(String name){
        System.out.println(name);
    }
    void paramTest(Integer name){
        System.out.println(name);
    }
}
