package com.example.zzmdemo.mapper;

import com.example.zzmdemo.common.Mapper;
import com.example.zzmdemo.core.SysMenu;
import com.example.zzmdemo.core.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<SysMenu> {

    SysUser userLogin(@Param("loginName")String loginName,@Param("password")String password);
}
