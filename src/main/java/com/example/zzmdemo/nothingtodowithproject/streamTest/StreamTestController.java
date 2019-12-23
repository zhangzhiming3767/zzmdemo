package com.example.zzmdemo.nothingtodowithproject.streamTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/18 14:05
 */
public class StreamTestController {

    public static void main(String[] args) {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());



    }

    public static void test2(){
        //在 Java 8 中, 集合接口有两个方法来生成流：
        //stream() − 为集合创建串行流。
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //parallelStream() − 为集合创建并行流。
        //filter 方法用于通过设置的条件过滤出元素
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<Integer> strings2 = Arrays.asList(11, 0, 22, 33, 1, 0, 3);
        strings2.stream().filter(string -> string>10).collect(Collectors.toList()).forEach(System.out::println);
        strings2.stream().filter(string -> string>10).forEach(System.out::println);
        System.out.println("strings" + strings);
        System.out.println("filtered" + filtered);
        strings.forEach(System.out::println);
        //Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
        Random random = new Random();
        //limit 方法用于获取指定数量的流
        random.ints().limit(10).forEach(System.out::println);
        //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        numbers.stream().limit(2).forEach(System.out::println);
        //sorted 方法用于对流进行排序
        numbers.stream().sorted().forEach(System.out::println);
        //获取对应的平方数
        //.distinct()去重
        List<Integer> squaresList2 = numbers.stream().distinct().map(i -> i * i).collect(Collectors.toList());
        System.out.println(squaresList2);
        //parallelStream 是流并行处理程序的代替方法,也就是多线程，多管道，线程不安全，需要自己加锁
        List<Integer> test=new ArrayList<>();
        for(int i=0;i<100;i++){
            test.add(i);
        }
        long count=test.parallelStream().filter(e->e>50).count();
        System.out.println(count);
    }

}
