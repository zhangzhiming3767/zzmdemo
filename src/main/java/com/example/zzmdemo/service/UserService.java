package com.example.zzmdemo.service;

import com.example.zzmdemo.common.IdGenerator;
import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  * @author zhangzhiming
  * description 用户管理
  * @date 16:10 2019/11/14
  */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private IdGenerator idGenerator;

     /**
      * @author zhangzhiming
      * description 登录
      * @date 16:10 2019/11/14
      */
    public SysUser userLogin(String loginName, String password) {
        return userMapper.userLogin(loginName,password);
    }


}
