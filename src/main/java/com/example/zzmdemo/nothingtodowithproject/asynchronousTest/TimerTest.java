package com.example.zzmdemo.nothingtodowithproject.asynchronousTest;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/6/21 10:36
 */
public class TimerTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ActionListener listener=new TimePrinter();
        Timer timer=new Timer(10000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "quit");
        System.exit(0);
    }
}
