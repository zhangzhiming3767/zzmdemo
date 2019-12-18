package com.example.zzmdemo.controller.javaBaseTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangzhiming
 * description
 * @date 17:28 2019/10/10
 */
public class MainTestController {

    public static void main(String[] args) {
//        System.out.println("22".hashCode());
        AtomicInteger test=new AtomicInteger();
        //自增
        test.getAndIncrement();
        System.out.println(test);
//        test13();
//        test12();
//        test11();
//        judgeEquals();
//        lambdaTest();
//        asyncTest();
//        forTest();
//        forTest2();
//        List<String> test1 = new ArrayList<>();
//        List<String> test2 = new ArrayList<>();
//        test2.add("1");
//        test2.add("2");
//        test2.addAll(test1);
//        System.out.println("22");
//        Integer a;
//        a=127;
//        String test="2019101100101";
//        a=Integer.valueOf(test);
//        a=Integer.getInteger(test);
//        System.out.println(a);
    }

    public static void test13() {
        List<String> test1=new ArrayList<>();
        test1.add("22");
        test1.add("33");
        test1.add("55");
        for(String test:test1){
            test=test+"1";
        }
        System.out.println(test1);
    }


    /**
     * @author :zhangzhiming
     * description :如果两个数都为1则为1，否则为0。
     * @date :Create in  2019/12/17 9:08
     */
    public static void test11() {
        int a = 0;
        if ((1 < 0) & (a++ > 0)) {

        }
        System.out.println("这是a：" + a);
        System.out.println(129 & 128);
    }

    /**
     * @author :zhangzhiming
     * description :相同为0，不同为1
     * @date :Create in  2019/12/17 10:13
     */
    public static void test12() {
        //01
        int a = 1;
        //10
        int b = 2;
        //11
        int c=3;
        System.out.println("第一个："+(2 ^ 1));
        System.out.println("第二个："+(2 ^ 3));
    }

    /**
     * @author :zhangzhiming
     * description :重写equals与hashCode
     * @date :Create in  2019/12/10 11:42
     */
    public static void judgeEquals() {
        List<String> test = new ArrayList<>(2);
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
//        System.out.println("isBlank:"+ StringUtils.isBlank(" "));
//        System.out.println("isEmpty:"+ StringUtils.isEmpty(" "));
//        StringUtils.split("","");
//        String a="233";
//        String b="233";
//        int c=10;
//        int d=10;
//        System.out.println("判断:"+a==b);
//        System.out.println("判断:"+a.equals(b));
//        System.out.println(c==d);
//        Student stu = new Student(123, "Tom");
//        HashSet<Student> set = new HashSet<>();
//        set.add(stu);
//        set.add(new Student(456, "Jerry"));
//        set.add(new Student(123, "Lily"));
//        Iterator<Student> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Student student = iterator.next();
//            System.out.println(student.getStuNum() + " --- " + student.getName());
//        }
    }

    /**
     * @author zhangzhiming
     * description 测一下   大循环写在内, 小循环写在外 两种写法的区别  抽空用多线程试试
     * @date 17:29 2019/10/10
     */
    private static void forTest() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
        int count = 0;
        System.out.println("开始时间1：" + date.format(new Date(System.currentTimeMillis())));
        for (int a = 0; a < 2147483647; a++) {
            for (int b = 0; b < 21474836; b++) {
                count++;
            }
        }
        System.out.println("结束时间1：" + count + " " + date.format(new Date(System.currentTimeMillis())));
    }

    private static void forTest2() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
        int count = 0;
        System.out.println("开始时间2：" + date.format(new Date(System.currentTimeMillis())));
        for (int a = 0; a < 21474836; a++) {
            for (int b = 0; b < 2147483647; b++) {
                count++;
            }
        }
        System.out.println("结束时间2：" + count + " " + date.format(new Date(System.currentTimeMillis())));
    }
}
