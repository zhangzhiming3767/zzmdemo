package com.example.zzmdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zzmdemo.entity.SysMenu;
import com.example.zzmdemo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserMapper extends BaseMapper<SysMenu> {

    SysUser userLogin(@Param("loginName")String loginName,@Param("password")String password);

    List<SysUser> userTest();
}
