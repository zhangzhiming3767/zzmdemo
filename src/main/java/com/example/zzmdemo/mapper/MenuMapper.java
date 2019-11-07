package com.example.zzmdemo.mapper;

import com.example.zzmdemo.common.Mapper;
import com.example.zzmdemo.core.SysMenu;
import com.example.zzmdemo.core.SysUser;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MenuMapper extends Mapper<SysMenu> {

    List<SysMenu> getMenuList();
}
