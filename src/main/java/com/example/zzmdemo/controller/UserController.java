package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.PageResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.service.JdbcTestService;
import com.example.zzmdemo.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangzhiming
 * description 用户管理
 * @date 16:07 2019/11/14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JdbcTestService jdbcTestService;

    /**
     * @author zhangzhiming
     * description 登录
     * @date 16:08 2019/11/14
     */
    @RequestMapping("/login")
    public Response userLogin(String loginName, String password) {
        return new ObjectResponse<>(userService.userLogin(loginName, password));
    }

    @RequestMapping("/getUserList")
    public PageResponse<SysUser> userTest(Integer pageNumber, Integer pageSize, HttpServletResponse response, HttpServletRequest request) {
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
