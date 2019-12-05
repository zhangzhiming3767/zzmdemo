package com.example.zzmdemo.service;

import com.example.zzmdemo.common.DataException;
import com.example.zzmdemo.common.IdGenerator;
import com.example.zzmdemo.core.SysUser;
import com.example.zzmdemo.mapper.JdbcTestMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class TestService {
    /**
     * @author zhangzhiming
     * description
     * @date 19:29 2019/10/9
     */
    public String userTest(Boolean a) throws Exception{
       if(a){
           throw new DataException("抓到你了奥");
       }else {
           throw new Exception("没抓到");
       }
//        return "没触发异常？";
    }


}
