package com.example.zzmdemo.controller;

import com.example.zzmdemo.common.DataException;
import com.example.zzmdemo.common.IdGenerator;
import com.example.zzmdemo.core.response.ObjectResponse;
import com.example.zzmdemo.core.response.Response;
import com.example.zzmdemo.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
  * @author zhangzhiming
  * description  接口测试    list.sort
  * @date 17:45 2019/10/17
  */
 @RestController
 @RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;
     @PostMapping("/exceptionTest")
     public Response quartzTest(Boolean a) {
         String result;
         try{
             result=testService.userTest(a);
         }catch (DataException e){
             result=e.getMessage();
         }catch (Exception e){
             result=e.getMessage();
         }
         return new ObjectResponse<>(result);
     }


}
