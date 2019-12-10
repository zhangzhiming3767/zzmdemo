package com.example.zzmdemo.mapper;

import com.example.zzmdemo.common.Mapper;
import com.example.zzmdemo.entity.SysMenu;
import com.example.zzmdemo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<SysMenu> {

    SysUser userLogin(@Param("loginName")String loginName,@Param("password")String password);
}
