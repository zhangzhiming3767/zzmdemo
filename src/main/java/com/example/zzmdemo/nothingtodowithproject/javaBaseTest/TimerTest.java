package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * java 原生定时任务
 *
 * @author zhangzhiming
 * @since 2020/6/17 20:09
 */
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
// 注意javax.swing包中也有一个Timer类，如果import中用到swing包,要注意名字的冲突。

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务的内容");//每次需要执行的代码放到这里面。
            }
        };
        //这个定时任务只能存在一个，不能创建2个，否则报错
        //以下是几种常用调度task的方法：
        // delay 为long类型：从现在起过delay毫秒之后执行一次（不周期）
//        timer.schedule(task, 2000L);
        // 从firstTime时刻开始，每隔period毫秒执行一次。
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timer.schedule(task, df.parse("2020-06-17 20:18:00"), 2000L);

    }
}
