package com.example.zzmdemo.service;

import com.example.zzmdemo.common.DataException;
import org.springframework.stereotype.Service;


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
