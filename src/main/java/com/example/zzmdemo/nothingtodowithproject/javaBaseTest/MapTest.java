package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        //遍历map的几种方式
        Map<String,String> mapTest=new HashMap<>();
        mapTest.put("这是第一个key","这是第一个value");
        mapTest.put("这是第2个key","2");
        for(String key:mapTest.keySet()){
            System.out.println(key+" "+mapTest.get(key));
        }
        Iterator<Map.Entry<String,String>> iterator=mapTest.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> map=iterator.next();
            System.out.println(map.getKey()+" "+map.getValue());
        }
        for(Map.Entry<String,String> entry:mapTest.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        for(String value:mapTest.values()){
            System.out.println(value);
        }
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
