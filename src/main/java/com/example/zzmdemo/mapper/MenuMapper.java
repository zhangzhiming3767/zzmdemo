package com.example.zzmdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zzmdemo.entity.SysMenu;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenuList();
}
