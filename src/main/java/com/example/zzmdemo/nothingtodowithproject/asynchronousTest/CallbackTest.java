package com.example.zzmdemo.nothingtodowithproject.asynchronousTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *   回调测试
 * @author zhangzhiming
 * @since 2020/6/21 15:35
 */
public class CallbackTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student student=new Student();
        student.setCallback(new Teacher());
        student.doTask();
    }
}
