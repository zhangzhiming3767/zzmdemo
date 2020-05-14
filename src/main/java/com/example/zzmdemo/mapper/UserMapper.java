package com.example.zzmdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper extends BaseMapper<SysUser> {

    SysUserVo userLogin(@Param("loginName") String loginName, @Param("password") String password);

    List<SysUser> userTest();
}
