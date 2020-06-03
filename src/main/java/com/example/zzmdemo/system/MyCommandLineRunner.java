package com.example.zzmdemo.system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/6/3 15:59
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... var1) throws Exception {
        System.err.println("实现CommandLineRunner来在启动项目时执行指定内容!");
    }
}
