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
        long beg = System.currentTimeMillis();
        //题目7的测试  整数反转
        int result = reverseV2(1534236469);
        System.out.println((System.currentTimeMillis() - beg));
        //3s
        System.out.println(result);
    }

    /**
     * 一些题目的调用
     */
    public void test() {
        //题目7的测试  整数反转
        int result2 = reverseV2(1534236469);
        //题目1的测试
//        addTwoNumbersTest();
        //题目2的测试
//        int size = getMaxSonStringV2("pwwkew");
        long beg = System.currentTimeMillis();
//        String result = getPalindromeV4("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
//                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        //题目3的测试
        String result = getPalindromeV4("qaabaabd");
        System.out.println((System.currentTimeMillis() - beg));
        //3s
        System.out.println(result);
    }

    /**
     * 题目7 整数反转  答案1 第一版
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x 入参
     * @return 返回值
     * 执行用时 :10 ms, 在所有 Java 提交中击败了6.95%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.33%的用户
     */
    public static int reverse(int x) {
        Boolean state = (x > 0);
        String temp = (state ? x : -x) + "";
        int size = temp.length();
        if (size == 1) {
            return x;
        }
        char[] arr = temp.toCharArray();
        int maxSize = (size % 2 > 0 ? size / 2 + 1 : size / 2);
        for (int i = 0; i < maxSize; i++) {
            char tem = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = tem;
        }
        StringBuilder result = new StringBuilder();
        if (!state) {
            result.append("-");
        }
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }
        try {
            return Integer.valueOf(result.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 对上面进行优化
     *
     * @param x 入参
     * @return 返回
     * 执行用时 :9 ms, 在所有 Java 提交中击败了7.63%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了5.33%的用户
     */
    public static int reverseV2(int x) {
        Boolean state = (x > 0);
        String temp = (state ? x : -x) + "";
        int size = temp.length();
        if (size == 1) {
            return x;
        }
        char[] arr = temp.toCharArray();
        StringBuilder result = new StringBuilder();
        if (!state) {
            result.append("-");
        }
        for (int i = size - 1; i >= 0; i--) {
            result.append(arr[i]);
        }
        try {
            return Integer.valueOf(result.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 题目7 答案3  这种解法的思路就是不断除以10，取出最右边的，不断乘以10，做累加，最后就是结果
     *时间复杂度：O(\log(x))O(log(x))，xx 中大约有 \log_{10}(x)log
     * 10
     * ​
     *  (x) 位数字
     * @param x 入参
     * @return 返回
     */
    public static int reverse3(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10 + res * 10;
            //最关键的一步
            if ((temp - x % 10) / 10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }

    /**
     * 题目3  有效答案1
     * 回文字符串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 入参
     *          执行用时 :412 ms, 在所有 Java 提交中击败了10.37%的用户
     *          内存消耗 :40.5 MB, 在所有 Java 提交中击败了15.18%的用户
     *          思路，从第一个取，从第二个开始判断是不是回文字符串，直至取到最后一个
     *          再从第二个开始取，
     *          时间复杂度为 O(n3）
     *          这就是暴力破解法，当然，在细节做了很多优化，实际时间是低于O(n3），当然，优化再多，改变不了3层循环的局面
     *          最初几版因执行时间太长都测试没通过，不得不进行反复优化
     */
    private static String getPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int size = s.length();
        if (size == 1) {
            return s;
        }
        int maxSize = 0;
        List<Character> resultList = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.clear();
            for (int j = i; j < size; j++) {
                list.add(s.charAt(j));
                int listSize = j - i + 1;
                //这里换了下前后顺序 提升了性能
                if (listSize > maxSize) {
                    boolean judge = true;
                    if (listSize > 1) {
                        int sizeTwo = (listSize % 2 == 0 ? listSize / 2 : (listSize - 1) / 2);
                        for (int k = 0; k < sizeTwo; k++) {
                            if (!Objects.equals(list.get(k), list.get(listSize - k - 1))) {
                                judge = false;
                                //这个时间省了一半
                                break;
                            }
                        }
                    }
                    if (judge) {
                        maxSize = listSize;
                        resultList = new ArrayList<>(list);
                    }
                }
            }
            //这也是一个优化点
            if (size - i - 1 < maxSize) {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character r : resultList) {
            result.append(r);
        }
        return result.toString();
    }


    /**
     * 题目3 参考答案2   时间复杂度O(n)
     * Manacher's Algorithm 马拉车算法
     * 时间复杂度：for 循环里边套了一层 while 循环，难道不是 O(n²)O(n²)？不！其实是 O(n)O(n)。
     * 不严谨的想一下，因为 while 循环访问 R 右边的数字用来扩展，也就是那些还未求出的节点，然后不断扩展，
     * 而期间访问的节点下次就不会再进入 while 了，可以利用对称得到自己的解，
     * 所以每个节点访问都是常数次，所以是 O ( n )O(n)。
     * <p>
     * Manacher 算法是基于“中心扩散法”，采用和 kmp 算法类似的思想，依然是“以空间换时间”
     * 1、分隔符是一个字符，种类也只有一个，并且这个字符一定不能是原始字符串中出现过的字符；
     * 2、加入了分隔符以后，使得“间隙”有了具体的位置，方便后续的讨论，并且新字符串中的任意一个回文子串在原始字符串中的一定能找到
     * 唯一的一个回文子串与之对应，因此对新字符串的回文子串的研究就能得到原始字符串的回文子串；
     * 3、新字符串的回文子串的长度一定是奇数；
     * 4、新字符串的回文子串一定以分隔符作为两边的边界，因此分隔符起到“哨兵”的作用。
     * <p>
     * 时间9 ms
     * 内存 39.4 M
     *
     * @param s 参数
     * @return 返回值
     */
    public static String getPalindromeV2(String s) {
        String t = preProcess(s);
        int n = t.length();
        int[] p = new int[n];
        // c 表示左边   r表示右边
        int c = 0, r = 0;
        for (int i = 1; i < n - 1; i++) {
            int iMirror = 2 * c - i;
            if (r > i) {
                // 防止超出 R   这行是算法的核心
                p[i] = Math.min(r - i, p[iMirror]);
            } else {
                // 等于 R 的情况
                p[i] = 0;
            }
            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            // 判断是否需要更新 R
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        //最开始讲的求原字符串下标
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static String getPalindromeV4(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 得到预处理字符串
        String str = preProcessV2(s);
        // 新字符串的长度
        int sLen = 2 * len + 1;
        // 数组 p 记录了扫描过的回文子串的信息
        int[] p = new int[sLen];
        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;
        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;
        for (int i = 0; i < sLen; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);
            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;
            }
            // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 原本给的答案是String拼接，改成StringBuilder后性能提升了好多
     * 首先我们解决下奇数和偶数的问题，在每个字符间插入 "#"，并且为了使得扩展的过程中，到边界后自动结束，在两端分别插入 "^" 和 "$"，
     * 两个不可能在字符串中出现的字符，这样中心扩展的时候，判断两端字符是否相等的时候，如果到了边界就一定会不相等，
     * 从而出了循环。经过处理，字符串的长度永远都是奇数了。
     *
     * @param s 入参
     * @return 返回值
     */
    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder();
        ret.append("^");
        for (int i = 0; i < n; i++) {
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#$");
        return ret.toString();
    }

    public static String preProcessV2(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#");
        return ret.toString();
    }

    /**
     * 题目3 参考答案3 扩展中心
     * 执行用时 38 ms, 在所有 Java 提交中击败了67.12%的用户
     * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了24.10%的用户
     * 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心。
     * 这个理解起来倒是不难
     *
     * @param s 入参
     * @return 返回
     */
    public static String getPalindromeV3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //这是奇数情况
            int len1 = expandAroundCenter(s, i, i);
            //这是偶数情况
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = (len1 > len2 ? len1 : len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
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
     *
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
            if (tmp.length - i <= result) {
                return result;
            }
            for (int j = i; j < tmp.length; j++) {
                if (!addSet.add(tmp[j])) {
                    if (result < addSet.size()) {
                        result = addSet.size();
                    }
                    break;
                } else if (j == tmp.length - 1 && result < addSet.size()) {
                    result = addSet.size();
                }
            }
        }
        return result;
    }

    /**
     * 题目2 有效答案2  这个版本多次改进
     * 执行用时 :112 ms, 在所有 Java 提交中击败了13.08%的用户
     * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了5.20%的用户
     *
     * @param s 入参
     * @return 返回长度
     * 对上面的方法进行里处理，内存消耗少了，但时间长了
     */
    public static int getMaxSonStringV2(String s) {
        //处理空格  空格返回1  意思是空格也算一个
        //这边去掉了对""的判断，时间内存都降低了
        if (s == null) {
            return 0;
        }
        int size = s.length();
        int result = 0;
        //这里用Character   而不用string，是从官方答案里学到的，确实没必要多一步转string的操作,
        // 改完后时间内存都下降了
        Set<Character> addSet = new HashSet<>();
        //双层循环试试
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                addSet.remove(s.charAt(i - 1));
                k--;
            }
            if (size - i <= result) {
                return result;
            }
            //优化点  当第二层到j出现重复时，i右移一位，j没必要从i开始，可以从上一次结束位置继续
            //这个优化完之后，时间降到了14ms
            for (int j = k; j < size; j++) {
                k++;
                if (!addSet.add(s.charAt(j))) {
                    if (result < addSet.size()) {
                        result = addSet.size();
                    }
                    break;
                } else if (j == size - 1 && result < addSet.size()) {
                    result = addSet.size();
                }
            }
        }
        return result;
    }

    /**
     * 题目2  官方给的答案
     *
     * @param s 入参
     * @return 执行用时 :8 ms, 在所有 Java 提交中击败了71.92%的用户
     * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了6.23%的用户
     * 看起来内存 消耗并没有小多少，但时间比我写的小多了，
     * <p>
     * 时间复杂度：O(N)O(N)，其中 NN 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 表示字符集（即字符串中可以出现的字符），
     * |\Sigma|∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0, 128)[0,128)
     * 内的字符，即 |\Sigma| = 128∣Σ∣=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有 |\Sigma|∣Σ∣ 个，
     * 因此空间复杂度为 O(|\Sigma|)O(∣Σ∣)。
     */
    public static int getMaxSonStringV3(String s) {
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
