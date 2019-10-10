package com.example.zzmdemo.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class TestsJobService implements Job {

    @Override
    @Transient
    public void execute(JobExecutionContext context) {
        String topicId = context.getJobDetail().getJobDataMap().get("parmww").toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=dateFormat.format(new Date());
        System.err.println("定时任务在" + time + "执行，接收到的参数是:" + topicId);
    }
}
