package com.example.zzmdemo.nothingtodowithproject.iocanddi;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/6/4 20:44
 */
public class IocTest {
    public static void main(String[] args){
        //旧的写法
//        Person person = new Person();
//        person.Wear();

        //而在IOC的设计思想中，我们将不再Person的内部进行创建Clothe属性的引用对象，而是在外界创建该对象，然后注入到Person对象中
        Wear wear= new Sweater();
        Person person = new Person();
        person.setClothe(wear);
        person.Wear();
    }
}
