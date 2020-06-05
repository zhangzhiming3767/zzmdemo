package com.example.zzmdemo.nothingtodowithproject.iocanddi;

import lombok.Data;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/6/4 20:39
 */
@Data
public class Person {
    private Wear clothe;


    /**
     * 在上面的代码中我们定义一个Wear接口，两个实现了该接口的类Sweater和Shirt，
     * 在Person类的Wear需要调用Wear接口的WearClothe方法，传统的做法是在Person的Wear中创建该接口的实现类，
     * 然后通过该对象对调用这个方法。在Person对象的内部创建了这个对象，既是控制了这个对象，
     * 当我们需要调用Shirt的WearClothe方法的时候就需要改动Person类中Wear方法的代码，
     * 去创建一个Shirt类对象。
     *
     * 而在IOC的设计思想中，我们将不再Person的内部进行创建Clothe属性的引用对象，
     * 而是在外界创建该对象，然后注入到Person对象中。
     */
//    public void Wear(){
//        clothe  = new Sweater();
//        clothe.WearClothe();
//    }
    public void Wear(){
        clothe.WearClothe();
    }
}
