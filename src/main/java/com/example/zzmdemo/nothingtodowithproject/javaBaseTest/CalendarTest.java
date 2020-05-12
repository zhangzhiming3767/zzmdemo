package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.util.Calendar;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *  Calendar类的使用
 * @author zhangzhiming
 * @since 2020/5/11 20:24
 */
public class CalendarTest {

    public static void main(String[] args){
        Calendar d=Calendar.getInstance();
        System.out.println(d);
        //获取当前的年份。
        System.out.println("获取当前的年份"+d.get(Calendar.YEAR));

        //获取当前的时间毫秒值。
        long time=d.getTimeInMillis();
        //打印时间毫秒值。
        System.out.println(time/1000);
        //修改对象d的年份
        d.set(Calendar.YEAR,2019);
        System.out.println(d.get(Calendar.YEAR));
        System.out.println(d.get(Calendar.YEAR)+""+d.get(Calendar.MONTH)+""+d.get(Calendar.DAY_OF_MONTH));
        //当n天以后
        d.add(Calendar.DAY_OF_MONTH,100);
        System.out.println(d.get(Calendar.YEAR)+""+d.get(Calendar.MONTH)+""+d.get(Calendar.DAY_OF_MONTH));


    }


}
