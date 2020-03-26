package com.example.zzmdemo.controller;

import com.example.zzmdemo.common.DataException;
import com.example.zzmdemo.entity.response.ObjectResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

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
         HashMap<String,String> test=new HashMap<>();
//         ConcurrentHashmap<String,String>
         ConcurrentHashMap<String,String> test2=new ConcurrentHashMap<>();
         Hashtable<String,String> test3=new Hashtable<>();
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

    @PostMapping(value={"/pathVariableTest/{orgName}"}, produces = "text/html;charset=UTF-8")
    public Response pathVariableTest(@PathVariable(required = false) String orgName) {
         System.out.println(orgName);
        return new SuccessResponse();
    }

    @PostMapping(value={"/stringTest"})
    public Response stringTest(@RequestParam String orgName)  {
        System.out.println("v1"+orgName);
//        String test=new String(orgName.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(test);
        return new SuccessResponse();
    }
    @PostMapping(value={"/stringTestV2"})
    public Response stringTestV2(@RequestBody String orgName)  {
        System.out.println("v2"+orgName);
        return new SuccessResponse();
    }


}
