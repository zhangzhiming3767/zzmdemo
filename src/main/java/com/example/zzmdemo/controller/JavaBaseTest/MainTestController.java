package com.example.zzmdemo.controller.JavaBaseTest;

import com.example.zzmdemo.entity.test.Student;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangzhiming
 * description
 * @date 17:28 2019/10/10
 */
public class MainTestController {

    public static void main(String[] args) {
        judgeEquals();


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

    /**
    * @author :zhangzhiming
    * description :重写equals与hashCode
    * @date :Create in  2019/12/10 11:42
    */
    public static void judgeEquals(){
        List<String> test=new ArrayList<>(2);
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
