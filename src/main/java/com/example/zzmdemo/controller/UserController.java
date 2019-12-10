package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


 /**
  * @author zhangzhiming
  * description 登录
  * @date 16:08 2019/11/14
  */
    @RequestMapping("/login")
    public Response userLogin(String loginName,String password) {
        return new ObjectResponse<>(userService.userLogin(loginName,password));
    }


}
