package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * @author zhangzhiming
  * description  接口测试    list.sort
  * @date 17:45 2019/10/17
  */
 @RestController
 @RequestMapping("/interfaceTest")
public class InterfaceTestController {

     @PostMapping("/exceptionTest")
     public Response quartzTest(String type) {
//         List<String> test=new ArrayList<>();
//         test.sort();
         throw new RuntimeException("Exception test");
//         return null;
     }


}
