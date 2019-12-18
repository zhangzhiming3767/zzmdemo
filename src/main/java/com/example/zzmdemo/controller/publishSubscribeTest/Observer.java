package com.example.zzmdemo.controller.publishSubscribeTest;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/18 11:21
 */
public interface Observer {
    //当主题状态改变时,更新通知
    public void update(int version);
}
