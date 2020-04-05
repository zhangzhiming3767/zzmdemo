package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.entity.SysUser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/4 14:56
 */
public class ObjectTest {

    public static void main(String[] args) {
        List<SysUser> sysUserList=new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setId("233");
        sysUserList.add(sysUser);
        sysUser.setId("345");
        sysUserList.add(sysUser);
        System.out.println("");
    }
}
