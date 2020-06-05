package com.example.zzmdemo.system;

import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.ApplicationContext;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 配置文件测试
 *
 * @author zhangzhiming
 * @since 2020/6/3 16:33
 */
@RestController
@RequestMapping("/test")
public class ApplicationTest {
    @Resource
    private ApplicationContext context;

    @RequestMapping(value = "/getApplication", method = RequestMethod.POST)
    @ApiOperation(value = "获取配置文件", notes = "根据id来获取用户详细信息")
    public Response applicationTest() {
        String springVersion = SpringVersion.getVersion();
        String springBootVersion = SpringBootVersion.getVersion();
        String profile = context.getEnvironment().getActiveProfiles()[0];
        return new SuccessResponse(springVersion+" "+springBootVersion+" "+profile);
    }
}
