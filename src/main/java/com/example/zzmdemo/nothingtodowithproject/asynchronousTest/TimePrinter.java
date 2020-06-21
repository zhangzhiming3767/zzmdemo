package com.example.zzmdemo.nothingtodowithproject.asynchronousTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/6/21 10:34
 */
public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        Date now=new Date();
        System.out.println("Now time is "+now);
        Toolkit.getDefaultToolkit().beep();
    }
}
