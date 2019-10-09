package com.example.zzmdemo.service;

import com.example.zzmdemo.core.SysUser;
import com.example.zzmdemo.mapper.JdbcTestMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class JdbcTestService {

    @Resource
    private JdbcTestMapper jdbcTestMapper;
     /**
      * @author zhangzhiming
      * description
      * @date 19:29 2019/10/9
      */
     public Page<SysUser> userTest(Integer pageNumber, Integer pageSize){
         PageHelper.startPage(pageNumber, pageSize);
         return ( Page<SysUser>)jdbcTestMapper.userTest();
     }

    public String addUser(SysUser sysUser){
//        sysUser.setId(idGenerator.nextId());
        sysUser.setCreateTime(new Date());
        int count=jdbcTestMapper.insert(sysUser);
        if(count==1){
            return "保存成功！";
        }else {
            return "保存失败！";
        }
    }
}
