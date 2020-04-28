package com.example.zzmdemo.dto;

import lombok.Data;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/4/26 20:38
 */
@Data
public class HeroNode {
    public int no;
    public String id;
    public String nickName;
    //指向下一个节点
    public HeroNode next;
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", id=" + id + ", nickName=" + nickName + "]";
    }
}
