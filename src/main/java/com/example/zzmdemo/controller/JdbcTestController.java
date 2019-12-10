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

    /**
     * @author zhangzhiming
     * description
     * @date 19:13 2019/10/9
     */
    @RequestMapping("/getUserList")
    public PageResponse<SysUser> userTest(Integer pageNumber, Integer pageSize, HttpServletResponse response) {
//         response.setHeader("Access-Control-Allow-Origin", "*");
//         response.setHeader("Access-Control-Allow-Methods", "POST");
        Page<SysUser> sysUserPage = jdbcTestService.userTest(pageNumber, pageSize);
        return new PageResponse<SysUser>(sysUserPage.getResult(), sysUserPage.getPageNum(), sysUserPage.getTotal());
    }

    @RequestMapping("/addUser")
    public Response addUser(@RequestBody SysUser sysUser) {
        return new SuccessResponse(jdbcTestService.addUser(sysUser));
    }

    @RequestMapping("/updateUser")
    public Response updateUser(@RequestBody SysUser sysUser) {
        return new SuccessResponse(jdbcTestService.updateUser(sysUser));
    }

}
