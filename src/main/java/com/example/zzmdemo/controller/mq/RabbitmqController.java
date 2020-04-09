package com.example.zzmdemo.controller.mq;

import com.example.zzmdemo.entity.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *https://blog.csdn.net/zhangyuxuan2/article/details/82986702
 * @author zhangzhiming
 * @since 2020/4/5 14:54
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Resource
    private Sender sender;

    @PostMapping("sendTest")
    public void importExcel()  {
        sender.send();
    }
}
