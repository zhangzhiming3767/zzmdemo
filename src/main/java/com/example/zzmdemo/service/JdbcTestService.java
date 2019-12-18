package com.example.zzmdemo.service;

import com.example.zzmdemo.common.IdGenerator;
import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.mapper.JdbcTestMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class JdbcTestService {

    @Resource
    private JdbcTestMapper jdbcTestMapper;
    @Resource
    private IdGenerator idGenerator;

    /**
     * @author zhangzhiming
     * description
     * @date 19:29 2019/10/9
     */
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
    public Page<SysUser> userTest(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return (Page<SysUser>) jdbcTestMapper.userTest();
    }

    public String addUser(SysUser sysUser) {
//        UUID test = idGenerator.generateId();
        sysUser.setId(idGenerator.nextId());
        sysUser.setCreateTime(new Date());
        int count = jdbcTestMapper.insert(sysUser);
        if (count == 1) {
            return "保存成功！";
        } else {
            return "保存失败！";
        }
    }

     /**
      * @author zhangzhiming
      * description
      * @date 17:15 2019/10/31
      */
     public String updateUser(SysUser sysUser) {
         sysUser.setCreateTime(new Date());
         int count = jdbcTestMapper.updateByPrimaryKeySelective(sysUser);
         if (count == 1) {
             return "保存成功！";
         } else {
             return "保存失败！";
         }
     }
}
