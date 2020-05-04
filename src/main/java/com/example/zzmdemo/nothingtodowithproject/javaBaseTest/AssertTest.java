package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  断言 得失
 * @author zhangzhiming
 * @since 2020/5/4 10:11
 */
public class AssertTest {

    public static void main(String args[]) {
        boolean isOpen = false;

        // 如果开启了断言，会将isOpen的值改为true
        assert isOpen = true;
        // 打印是否开启了断言，如果为false，则没有启用断言
        System.out.println(isOpen);

        useAssertExt2();
    }

    /**
     * 断言的第一个例子
     */
    public static void useAssertExt2() {
        boolean isOk = 1 > 2;
        try {
            assert isOk : "程序错误";
            System.out.println("程序正常");
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
        }
    }

}
