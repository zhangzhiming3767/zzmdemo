package com.example.zzmdemo.mapper;

import com.example.zzmdemo.common.Mapper;
import com.example.zzmdemo.core.SysUser;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface JdbcTestMapper extends Mapper<SysUser> {

    List<SysUser> userTest();
}
