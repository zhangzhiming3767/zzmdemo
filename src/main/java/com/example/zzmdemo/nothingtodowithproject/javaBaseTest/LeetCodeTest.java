package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.dto.leetcode.ListNode;

import java.util.*;

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
//        addTwoNumbersTest();
        //题目2的测试
        int size = getMaxSonStringV2("");
        System.out.println(size);
    }

    /**
     * 回文字符串
     */
    private static String get(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        String[] tmp = new String[s.length()];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = String.valueOf(s.charAt(i));
        }
        int maxSize = 0;
        String result = null;
        //思路，从第一个取，从第二个开始判断是不是回文字符串，直至取到最后一个
        //再从第二个开始取，

        for (int i = 0; i < tmp.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i; j < tmp.length; j++) {
                list.add(tmp[j]);
                if (judge(list) && list.size() > maxSize) {
                    maxSize = list.size();
                    result = list.toString();
                }
            }
        }
        return result;
    }

    private static boolean judge(List<String> list) {
        if (list == null || list.size() < 2) {
            return false;
        }
        int listSize = list.size();
        int size = (listSize % 2 == 0 ? listSize / 2 : (listSize - 1) / 2);
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(list.get(i), list.get(listSize - i - 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 题目2  有效答案1
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 执行用时 :105 ms, 在所有 Java 提交中击败了13.87%的用户
     * 内存消耗 :42 MB, 在所有 Java 提交中击败了  <   5.20%的用户
     * @param s
     * @return
     */
    public static int getMaxSonString(String s) {
        //处理空格  空格返回1  意思是空格也算一个
        if (s == null || "".equals(s)) {
            return 0;
        }
        String[] tmp = new String[s.length()];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = String.valueOf(s.charAt(i));
        }
        int result = 0;
        Set<String> addSet = new HashSet<>();
        //双层循环试试
        for (int i = 0; i < tmp.length; i++) {
            addSet.clear();
            if(tmp.length-i<=result){
                return result;
            }
            for (int j = i; j < tmp.length; j++) {
                if (!addSet.add(tmp[j])) {
                    if (result < addSet.size()) {
                        result = addSet.size();
                    }
                    break;
                }else if(j==tmp.length-1 && result < addSet.size()){
                        result = addSet.size();
                }
            }
        }
        return result;
    }

    /**
     * 题目2 有效答案2
     * 执行用时 :112 ms, 在所有 Java 提交中击败了13.08%的用户
     * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了5.20%的用户
     * @param s  入参
     * @return 返回长度
     * 对上面的方法进行里处理，内存消耗少了，但时间长了
     */
    public static int getMaxSonStringV2(String s) {
        //处理空格  空格返回1  意思是空格也算一个
        //这边去掉了对""的判断，时间内存都降低了
        if (s == null) {
            return 0;
        }
        int size=s.length();
        int result = 0;
        //这里用Character   而不用string，是从官方答案里学到的，确实没必要多一步转string的操作,
        // 改完后时间内存都下降了
        Set<Character> addSet = new HashSet<>();
        //双层循环试试
        for (int i = 0; i < size; i++) {
            addSet.clear();
            if(size-i<=result){
                return result;
            }
            //优化点  当第二层到j出现重复时，i右移一位，j没必要从i开始，可以从上一次结束位置继续
            for (int j = i; j < size; j++) {
                if (!addSet.add(s.charAt(j))) {
                    if (result < addSet.size()) {
                        result = addSet.size();
                    }
                    break;
                }else if(j==size-1 && result < addSet.size()){
                    result = addSet.size();
                }
            }
        }
        return result;
    }

    /**
     *题目2  官方给的答案
     * @param s 入参
     * @return
     * 执行用时 :8 ms, 在所有 Java 提交中击败了71.92%的用户
     * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了6.23%的用户
     * 看起来内存 消耗并没有小多少，但时间比我写的小多了，
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 表示字符集（即字符串中可以出现的字符），
     * |\Sigma|∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0, 128)[0,128)
     * 内的字符，即 |\Sigma| = 128∣Σ∣=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有 |\Sigma|∣Σ∣ 个，
     * 因此空间复杂度为 O(|\Sigma|)O(∣Σ∣)。
     */
    public static int getMaxSonStringV3(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    /**
     * 题目1的测试
     */
    private static void addTwoNumbersTest() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l61 = new ListNode(9);
        ListNode l62 = new ListNode(9);
        ListNode l43 = new ListNode(9);
        ListNode l64 = new ListNode(9);
        ListNode l65 = new ListNode(9);
        ListNode l66 = new ListNode(9);
        ListNode l67 = new ListNode(9);

        l66.next = l67;
        l65.next = l66;
        l64.next = l65;
        l43.next = l64;
        l62.next = l43;
        l61.next = l62;
        l6.next = l61;
        l4.next = l6;
        l2.next = l4;
        ListNode temp = addTwoNumbersV3(l1, l2);
        System.out.println("");
    }

    /**
     * 题目1  有效答案一
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1 参数1
     * @param l2 参数2
     * @return 执行用时 :4 ms, 在所有 Java 提交中击败了7.57%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了93.78%的用户
     * <p>
     * 解读：最初的思路就是用数组存储，然后计算，但考虑情况不全面，测试老是不通过，考虑到进1位的问题，忘记考虑连续进位的情况，
     * 最后想直接用int或long来计算值，
     * 于是就有了 addTwoNumbersV2 方法，但测试遇到很长的链表时，数据超上限了，
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
        boolean addState = false;
        if (listOne.size() > listTwo.size()) {
            for (int i = 0; i < listOne.size(); i++) {
                Integer value = (i < listTwo.size() ? listTwo.get(i) : 0) + listOne.get(i);
                if (addState) {
                    value++;
                    addState = false;
                }
                if (value > 9) {
                    listThree.add(value - 10);
                    addState = true;
                } else {
                    listThree.add(value);
                }
            }
        } else {
            for (int i = 0; i < listTwo.size(); i++) {
                Integer value = (i < listOne.size() ? listOne.get(i) : 0) + listTwo.get(i);
                if (addState) {
                    value++;
                    addState = false;
                }
                if (value > 9) {
                    listThree.add(value - 10);
                    addState = true;
                } else {
                    listThree.add(value);
                }
            }
        }
        if (addState) {
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
        ListNode temp = result;
        if (listThree.size() > 1) {
            for (int i = 1; i < listThree.size(); i++) {
                ListNode add = new ListNode(listThree.get(i));
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = add;
            }

        }
        return result;
    }

    /**
     * 不可用 这个方法在数据不长时没问题，但过长时会达到上限
     *
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
        for (int i = 0; i < str.length(); i++) {
            tmp[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
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

    /**
     * 题目一  参考答案2 官方给的
     * 这个解法比我写的主要思路是一样的，但写法简洁了很多，效率也会高很多
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersV3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
