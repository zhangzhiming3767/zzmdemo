package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/16 11:21
 */
@RestController
@RequestMapping("/shiro")
public class ShiroTestController {

    @PostMapping("/test1")
    @RequiresPermissions(value = {"test1","test2",}, logical = Logical.OR)
    public Response shiroTest1() {
        System.out.println("有权限");
        return new ObjectResponse<>("");
    }

    @PostMapping("/test2")
    @RequiresPermissions(value = {"1122"}, logical = Logical.OR)
    public Response shiroTest2() {
        System.out.println("没权限");
        return new ObjectResponse<>("");
    }
}
