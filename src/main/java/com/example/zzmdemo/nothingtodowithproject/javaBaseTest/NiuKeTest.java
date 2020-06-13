package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 牛客网的测试题
 *
 * @author zhangzhiming
 * @since 2020/6/9 23:32
 */
public class NiuKeTest {

    public static void main(String[] args) throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nextSrting = scanner.nextInt();
            if (nextSrting < 1 || nextSrting > 500000) {
                System.out.println(-1);
                return;
            }
            if (nextSrting == 1) {
                System.out.println(0);
                return;
            }
            int count = 0;
            for (int i = 2; i < nextSrting; i++) {
                Integer sum = 0;
                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

//    Scanner s = new Scanner(System.in);
//    List<String> result=new ArrayList<>();
//        while(s.hasNext()){
//        String a=s.nextLine();
//        if(a.length()==1 && Integer.valueOf(a)==0 ){
//            break;
//        }
//        String []arr=a.split(" ");
//        int sum=0;
//        for(int i=0;i<arr.length;i++){
//            sum+=Integer.valueOf(arr[i]);
//        }
//        result.add(sum+"");
//    }
//        result.forEach(System.out::println);

    /**
     * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
     * 5，1，1和1，5，1 是同一种分法。
     * 递归
     */
    private static int getCounts(int a, int max) {
        int count = 0;
        for (int i = 0; i < a; i++) {
            if (a - i == 1 && i == max) {
                count++;
            }
        }
        return count;
        //把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
        //每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
        //每一个苹果都可能放到每一个盘子里，怎么穷举？
        //7 3  结果8
        //700  70
        //610
        //520
        //511   43
        //430
        //421
        //  4111
        //313
        //322
        // 70 61 52 43
        //


    }

    private void test() throws ScriptException {
        // 计算表达式的值
        getSum();

        Scanner in = new Scanner(System.in);
        String d = in.nextLine();
        char[] arr = d.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            result.append(arr[i]);
        }
        System.out.println(result.toString());

        double c = in.nextDouble();
        //求立方根,保留一位小数
        System.out.println(getResult(0, c, c));

        //这是计算最小公倍数的测试
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(lcm(a, b));
        //转成2进制后，1的个数
        System.out.println(getTwo(a));

    }

    /**
     * 字符串排序
     */
    private static void charOrder() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String test = in.nextLine();
            char[] arr = test.toCharArray();
            List<Character> list = new ArrayList<>();
            for (char c : arr) {
                list.add(c);
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) > list.get(j)) {
                        char temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
            list.forEach(System.out::print);
        }
    }

    /**
     * 百钱白鸡问题
     */
    private static void buyChicken() {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        //5,3,1/3  100钱买100鸡
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 33; j++) {
                for (int k = 0; k < 300; k += 3) {
                    if (i + j + k == 100 && 5 * i + 3 * j + k / 3 == 100) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }

    /**
     * 密码强度wenti
     */
    private static void passwordTest() {
        Scanner in = new Scanner(System.in);
        String d = in.nextLine();
        int score = 0;
        if (d.length() <= 4) {
            score += 5;
        } else if (d.length() <= 7) {
            score += 10;
        } else {
            score += 25;
        }
        boolean haveS = false;
        boolean haveM = false;
        int havaN = 0;
        int charCount = 0;
        char[] arr = d.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!haveS && arr[i] >= 97 && arr[i] <= 122) {
                haveS = true;
            }
            if (!haveM && arr[i] >= 65 && arr[i] <= 90) {
                haveM = true;
            }
            if (arr[i] >= 0 && arr[i] <= 9) {
                havaN++;
            } else if ((arr[i] >= 33 && arr[i] <= 47) || (arr[i] >= 58 && arr[i] <= 64) || (arr[i] >= 91 && arr[i] <= 96) || (arr[i] >= 123 && arr[i] <= 126)) {
                charCount++;
            }
        }
        if (havaN > 1) {
            score += 20;
        } else if (havaN == 1) {
            score += 10;
        }
        if (haveS) {
            if (haveM) {
                score += 20;
            } else {
                score += 10;
            }
        }
        if (charCount > 1) {
            score += 25;
        } else if (charCount == 1) {
            score += 10;
        }
        if (havaN > 0 && charCount > 0 && haveS && haveM) {
            score += 5;
        } else if (havaN > 0 && charCount > 0 && (haveS || haveM)) {
            score += 3;
        } else if (havaN > 0 && (haveS || haveM)) {
            score += 2;
        }
        System.out.println();
        if (score >= 90) {
            System.out.println("VERY_SECURE");
        } else if (score >= 80) {
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }

    }


    /**
     * 根据字节取字符串内容
     * utf-8转gbk
     */
    private static void chinese() throws UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String[] strs = new String[str.length()];
            for (int i = 0; i < strs.length; i++) {
                strs[i] = String.valueOf(str.charAt(i));
            }
            int byteNum = sc.nextInt();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                int chLen = strs[i].getBytes("GBK").length;
                if (byteNum >= chLen) {
                    byteNum -= chLen;
                    res.append(strs[i]);
                } else {
                    break;
                }
            }
            System.out.println(res.toString());

        }
    }

    /**
     * 24点，超时
     *
     * @throws ScriptException
     */
    private static void test2() throws ScriptException {
        Scanner in = new Scanner(System.in);
        String d = in.nextLine();
        if (d.contains("joker") || d.contains("JOKER")) {
            System.out.println("ERROR");
            return;
        }
        d = d.replace("J", "11");
        d = d.replace("Q", "12");
        d = d.replace("K", "13");
        d = d.replace("A", "1");
        String[] aa = d.split(" ");
        List<String> map = new ArrayList<>();
        map.add("+");
        map.add("-");
        map.add("*");
        map.add("/");
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int m = 0; m < 4; m++) {
                        if (m == i || m == j || m == k) {
                            continue;
                        }
                        for (int n = 0; n < 4; n++) {
                            for (int g = 0; g < 4; g++) {
                                for (int h = 0; h < 4; h++) {
                                    Object s = engine.eval(engine.eval(engine.eval(aa[i] + map.get(n) + aa[j]) + map.get(g) + aa[k]) + map.get(h) + aa[m]);
                                    if (s instanceof Integer && (Integer) s == 24) {
                                        System.out.println(aa[i] + map.get(n) + aa[j] + map.get(g) + aa[k] + map.get(h) + aa[m]);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("NONE");
    }


    /**
     * 表达式求值
     */
    private static void getSum() throws ScriptException {
        Scanner sc = new Scanner(System.in);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        while (sc.hasNext()) {
            String str = sc.next();
            Integer eval = (Integer) engine.eval(str);
            System.out.println(eval);

        }
    }

    /**
     * 转成2进制后，1的个数
     *
     * @param a
     * @return
     */
    private static int getTwo(int a) {
        int count = 0;
        if (a % 2 == 1) {
            count++;
        }
        a = a / 2;
        if (a > 0) {
            count += getTwo(a);
        }
        return count;
    }

    /**
     * 字符串切分问题
     */
    private static void temp() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int counts = scanner.nextInt();
            List<String> list = new ArrayList<>();
            while (counts >= 0) {
                String add = scanner.nextLine();
                list.add(add);
                counts--;
            }
            for (int i = 0; i < list.size(); i++) {
                String tempString = list.get(i);
                if (tempString == null || tempString.length() == 0) {
                    continue;
                }
                int size = tempString.length();
                if (size == 8) {
                    System.out.println(tempString);
                } else {
                    while (tempString.length() >= 8) {
                        System.out.println(tempString.substring(0, 8));
                        tempString = tempString.substring(8, tempString.length());
                    }
                    if (0 < tempString.length()) {
                        StringBuilder temp = new StringBuilder();
                        temp.append(tempString);
                        for (int j = 0; j < (8 - tempString.length()); j++) {
                            temp.append("0");
                        }
                        System.out.println(temp.toString());
                    }
                }
            }
        }
    }


    /**
     * 求立方根
     * 用的是夹逼方法，经度要求不高的话，还是可以的。有空可以看看牛顿迭代法
     *
     * @param a 起始值
     * @param b 结束值
     * @param c 入参
     * @return 保留一位小数的立方根
     */
    private static double getResult(double a, double b, double c) {
        if (a * a * a == c) {
            return a;
        }
        if (b * b * b == c) {
            return b;
        }
        //Math.round 取整4舍五入
        if (Math.abs(b - a) <= 0.1) {
            return (Math.abs(b * b * b - c) > Math.abs(a * a * a - c) ? ((double) Math.round(a * 10) / 10) : ((double) Math.round(b * 10) / 10));
        }
        if ((a + b) * (a + b) * (a + b) / 8 > c) {
            if (c > 0) {
                return getResult(a, (a + b) / 2, c);
            }
            return getResult((a + b) / 2, b, c);
        } else {
            if (c > 0) {
                return getResult((a + b) / 2, b, c);
            }
            return getResult(a, (a + b) / 2, c);
        }
    }

    /**
     * 求最小公倍数：公式法
     * 两个数a,b的最小公倍数是a*b/gcd(a,b)
     * 由于两个数的乘积等于这两个数的最大公约数与最小公倍数的积，即（a，b）× [a，b] = a × b
     * 所以，求两个数的最小公倍数，就可以先求出它们的最大公约数，然后用上述公式求出它们的最小公倍数。
     */
    private static int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }

    /**
     * 求最大公约数：辗转相除法
     * 1\. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
     * 2\. 互换：置 a←b，b←r，并返回第一步
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 负数的个数
     */
    private static void number() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextSrting = scanner.nextLine();
            String[] arr = nextSrting.split(" ");
            int count = 0;
            int sum = 0;
            for (String a : arr) {
                if (Integer.valueOf(a) < 0) {
                    count++;
                } else {
                    sum += Integer.valueOf(a);
                }
            }
            System.out.println(count);
            System.out.println((arr.length - count == 0) ? 0 : String.format("%.1f", (double) sum / (arr.length - count)));
        }
    }
}
