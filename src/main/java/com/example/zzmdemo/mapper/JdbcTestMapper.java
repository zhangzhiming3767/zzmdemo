package com.example.zzmdemo.mapper;

import com.example.zzmdemo.common.Mapper;
import com.example.zzmdemo.core.SysUser;

import java.util.List;

public interface JdbcTestMapper extends Mapper<SysUser> {

    List<SysUser> userTest();
}
