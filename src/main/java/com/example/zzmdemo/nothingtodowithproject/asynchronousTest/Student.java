package com.example.zzmdemo.nothingtodowithproject.asynchronousTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/6/21 15:34
 */
public class Student {
    private Callback callback=null;
    //将老师的联系信息给学生
    public void setCallback(Callback callback)
    {
        this.callback=callback;
    }
    public void doTask()
    {
        for(int m=1;m<6;m++)
        {
            callback.taskResult(m+"是张三");
        }
    }
}
