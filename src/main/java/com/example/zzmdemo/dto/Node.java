package com.example.zzmdemo.dto;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/11 21:35
 */
public class Node {
    public Object e;
    public Node next;
    public Node pre;
    public Node(){

    }
    public Node(Object e){
        this.e = e;
        next = null;
        pre = null;
    }
}
