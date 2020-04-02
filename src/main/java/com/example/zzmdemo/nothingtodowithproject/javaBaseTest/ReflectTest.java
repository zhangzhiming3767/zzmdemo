package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.entity.SysUser;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  反射相关的测试
 * @author zhangzhiming
 * @since 2020/3/31 21:29
 */
public class ReflectTest {

    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        Class<?> perClazz = sysUser.getClass();
        Method[] methods = perClazz.getMethods();
        Constructor<?>[] constructor=perClazz.getConstructors();
        Class<?> superclass=perClazz.getSuperclass();
        Field[] declaredFields=perClazz.getDeclaredFields();
        System.out.println("");
    }
}
