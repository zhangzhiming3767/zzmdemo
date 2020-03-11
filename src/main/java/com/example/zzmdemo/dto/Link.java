package com.example.zzmdemo.dto;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/11 22:36
 */
public class Link<T> {
    public T val;
    public Link<T> next;
    public Link<T> pre;

    public Link(T val) {
        this.val = val;
    }

    public void displayCurrentNode() {
        System.out.print(val + "  ");
    }
}
