package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/23 17:16
 */
public class ImplementsDemoOne implements InterfaceDemo{

    @Override
    public void showMessage() {
        System.out.println("ImplementsDemoOne 被调用了");
    }
}
