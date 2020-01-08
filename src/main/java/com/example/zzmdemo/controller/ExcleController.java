package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2019/12/30 19:48
 */
@RestController
@RequestMapping("/export")
public class ExcleController {
    @Resource
    private UserService userService;


}
