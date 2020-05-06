package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.dto.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 力扣 算法题
 *
 * @author zhangzhiming
 * @since 2020/5/3 10:00
 */
public class LeetCodeTest {

    public static void main(String[] args) {
        //题目1的测试
        addTwoNumbersTest();
        System.out.println("");
        //TODO 进一位的情况没有考虑到
    }

    /**
     * 题目1的测试
     */
    private static void addTwoNumbersTest(){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l4=new ListNode(9);
        ListNode l6=new ListNode(9);
        ListNode l61=new ListNode(9);
        ListNode l62=new ListNode(9);
        ListNode l43=new ListNode(9);
        ListNode l64=new ListNode(9);
        ListNode l65=new ListNode(9);
        ListNode l66=new ListNode(9);
        ListNode l67=new ListNode(9);

        l66.next=l67;
        l65.next=l66;
        l64.next=l65;
        l43.next=l64;
        l62.next=l43;
        l61.next=l62;
        l6.next=l61;
        l4.next=l6;
        l2.next=l4;
        ListNode temp = addTwoNumbers(l1, l2);
        System.out.println("");
    }

    /**
     *  题目1  有效答案一
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1  参数1
     * @param l2  参数2
     * @return
     * 执行用时 :4 ms, 在所有 Java 提交中击败了7.57%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了93.78%的用户
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        List<Integer> listThree = new ArrayList<>();
        while (l1 != null) {
            listOne.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            listTwo.add(l2.val);
            l2 = l2.next;
        }
        boolean addState=false;
        if (listOne.size() > listTwo.size()) {
            for (int i =0; i <listOne.size(); i++) {
                Integer value = (i < listTwo.size() ? listTwo.get(i) : 0) + listOne.get(i);
                if(addState){
                    value++;
                    addState=false;
                }
                if (value > 9) {
                    listThree.add(value-10);
                    addState=true;
                } else {
                    listThree.add(value);
                }
            }
        } else {
            for (int i =0; i<listTwo.size(); i++) {
                Integer value = (i < listOne.size() ? listOne.get(i) : 0) + listTwo.get(i);
                if(addState){
                    value++;
                    addState=false;
                }
                if (value > 9) {
                    listThree.add(value-10);
                    addState=true;
                }else {
                    listThree.add(value);
                }
            }
        }
        if(addState){
            listThree.add(1);
        }
        ListNode result = new ListNode(listThree.get(0));
        //头插
//        if (listThree.size() > 1) {
//            for (int i = 1; i < listThree.size(); i++) {
//                ListNode add = new ListNode(listThree.get(i));
//                add.next = result;
//                result = add;
//            }
//        }

        //尾插
        ListNode temp=result;
        if (listThree.size() > 1) {
            for (int i = 1; i < listThree.size(); i++) {
                ListNode add = new ListNode(listThree.get(i));
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=add;
            }

        }
        return result;
    }

    /**
     * 这个方法在数据不长时没问题，但过长时会达到上限
     * @param l1 参数1
     * @param l2 参数2
     * @return 结果
     */
    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        long value = 0;
        long num = 1;
        while (l1 != null) {
            value += l1.val * num;
            num = 10 * num;
            l1 = l1.next;
        }
        num = 1;
        while (l2 != null) {
            value += l2.val * num;
            num = 10 * num;
            l2 = l2.next;
        }
        String str = String.valueOf(value);
        int[] tmp = new int[str.length()];
        for(int i=0;i<str.length();i++){
            tmp[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        ListNode result = new ListNode(tmp[0]);
        if (tmp.length > 1) {
            for (int i = 1; i < tmp.length; i++) {
                ListNode add = new ListNode(tmp[i]);
                add.next = result;
                result = add;
            }
        }
        return result;
    }
}
