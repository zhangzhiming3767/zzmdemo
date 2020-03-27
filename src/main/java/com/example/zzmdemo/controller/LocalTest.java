package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.nothingtodowithproject.lockTest.SynchronizedTest;
import com.example.zzmdemo.nothingtodowithproject.lockTest.Ticket;
import com.example.zzmdemo.nothingtodowithproject.lockTest.servenMethod.Bank;
import com.example.zzmdemo.nothingtodowithproject.lockTest.servenMethod.MybanRunnable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/26 11:38
 */
@RestController
@RequestMapping("/localTest")
public class LocalTest {
    @PostMapping(value={"/stringTest"})
    public Response stringTest(Integer type)  {
        SynchronizedTest r = new SynchronizedTest();
        for (int a = 0; a < 10000; a++) {
            Thread t = new Thread(r);
            t.start();
        }
        System.out.println("111:"+(r.count));
        System.out.println("222:"+(r.count3));
        System.out.println("333:"+(r.count2));
        System.out.println("444:"+(r.getAccount3()));
        return new SuccessResponse();
    }
}
