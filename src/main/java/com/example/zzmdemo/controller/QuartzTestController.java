package com.example.zzmdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.zzmdemo.entity.quartz.InitJobService;
import com.example.zzmdemo.entity.response.FailedResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import com.example.zzmdemo.service.JdbcTestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
  * @author zhangzhiming
  * description
  * @date 20:56 2019/10/9
  */
@RestController
@RequestMapping("/quartz")
public class QuartzTestController {
    @Resource
    private JdbcTestService jdbcTestService;
    @Resource
    private InitJobService initJobService;
    /**
     * @param type 1创建 2停止 3删除 4重启
     * @author :zhangzhiming
     * description :定时任务测试 22
     * @date :Create in  2019/5/27 14:57
     */
    @PostMapping("/quartzTest")
    public Response quartzTest(String type) {
        Random r = new Random(1);
        Integer x = r.nextInt(20);
        Map newJson = new HashMap(1);
        newJson.put("parmww", x.toString());
        JSON sendScore5 = new JSONObject(newJson);
        String sendScore = sendScore5.toString();
        String corn = "0/5 * * * * ? ";
        String className = "com.example.zzmdemo.service.TestsJobService";
        if ("1".equals(type)) {
            return initJobService.addJob("test1", "第一个测试定时任务", className, corn, sendScore);
        } else if ("2".equals(type)) {
            return initJobService.pauseJob("test1", className, corn);
        } else if ("3".equals(type)) {
            return initJobService.removeJob("test1", className, corn);
        } else if ("4".equals(type)) {
            return initJobService.resumeJob("test1", className, corn);
        } else {
            return new FailedResponse("参数错误");
        }
    }

     /**
      * @author zhangzhiming
      * description  启动时执行，进行初始化
      * @date 16:05 2019/10/17
      */
    @PostConstruct
    @RequestMapping(value = "/initializingTest", method = RequestMethod.GET)
    public Response initializing() {
        System.err.println("看到了吗看到了吗看到了吗看到了吗看到了吗看到了吗看到了吗看到了吗");
        return new SuccessResponse();
    }

}
