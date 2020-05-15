package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.service.MenuService;
import com.example.zzmdemo.utils.token.UserLoginToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangzhiming
 * description 菜单管理
 * @date 11:11 2019/11/5
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;


    /**
     * @author zhangzhiming
     * description 获取菜单列表
     * @date 11:20 2019/11/5
     */
//    @UserLoginToken
    @RequestMapping("/getMenuList")
    public Response userTest() {
        return new ObjectResponse<>(menuService.getMenuList());
    }


}
