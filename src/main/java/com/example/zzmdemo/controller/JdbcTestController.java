package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.entity.response.PageResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.service.JdbcTestService;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangzhiming
 * description
 * @date 19:06 2019/10/9
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcTestController {
    @Resource
    private JdbcTestService jdbcTestService;



}
