package com.example.zzmdemo.nothingtodowithproject;

import java.util.Arrays;

/**
 * 应用模块名称<p>
 * 代码描述<p>   字符串匹配算法-KMP,不同于indexof的暴力破解法
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/8 15:28
 */
public class KMP {

    public static void main(String[] args) {
        getNextTest("aac");
//        getNext("ababaa");
//        getNext("abaabcac");
//        getNextArray("abaabcac".toCharArray());
//        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
    }
    /**
     * @author :zhangzhiming
     * description :
     * @date :Create in  2020/3/8 16:55
     */
    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    /**
    * @author :zhangzhiming
    * description :根据理解，自己写一个获取next数据的方法
    * @date :Create in  2020/3/8 21:08
    */
    public static int[] getNextTest(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        next[1] = 0;
        int j = 1;
        int k = 0;
        while (j < p.length - 1) {
            if (k == -1 ) {
                next[++j] = 0;
                k=0;
            }else if( p[j] == p[k]){
                // k值实际是j位前的子串的最大重复子串的长度
                k=k+1;
                //往后移动一位
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     *
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i < s_arr.length && j < t_arr.length) {
            if (j == -1 || s_arr[i] == t_arr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t_arr.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
    * @author :zhangzhiming
    * description :根据理解，拆分一下，把上面的按照自己理解进行拆解
    * @date :Create in  2020/3/8 19:32
    */
    public static int kmpMatchTest(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i < s_arr.length && j < t_arr.length) {
            //如果是第一位不等，s往后取一位，j归零，也就是t去第一位，
            //若是相等，则判断下一个是否相等，若相等，则再判断下一位，否则取一下j，来确定应该移动几位
            if (j == -1 ) {
                i++;
                j=0;
                //可以与下面的else合并，但不好理解
            }else if(s_arr[i] == t_arr[j]){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        //t数组移动完了，说了每一项都匹配上了，那么开始的位置就是最后的位置i减去目标字段j的长度
        if (j == t_arr.length) {
            return i - j;
        } else {
            //要不然就是没找到
            return -1;
        }
    }

    /**
     * 求出一个字符数组的next数组
     *
     * @param t 字符数组
     * @return next数组
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
                next[j] = 0;
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }


}
