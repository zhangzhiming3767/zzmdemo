package com.example.zzmdemo.entity.quartz;

import com.alibaba.fastjson.JSON;
import com.example.zzmdemo.entity.response.FailedResponse;
import com.example.zzmdemo.entity.response.PageResponse;
import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author ChenHao
 * @Description 定时任务调度
 * @date 2018/7/23
 */
@Service
public class InitJobService {
    @Autowired
    private JobService jobService;

    /**
     * 查询job
     *
     * @param jobName 任务名称
     * @return List<InitjobDTO> 分页
     */
    public Response queryJobs(String jobName, String state, Integer pageNumber, Integer pageSize) {
        try {
            //所有的job
            List<InitjobDTO> jobs = jobService.queryJobs(jobName, state);
            //进行list分页处理
            List<InitjobDTO> jobsPage = new ArrayList<>();
            int currIdx = (pageNumber > 1 ? (pageNumber - 1) * pageSize : 0);
            for (int i = 0; i < pageSize && i < jobs.size() - currIdx; i++) {
                InitjobDTO job = jobs.get(currIdx + i);
                jobsPage.add(job);
            }
            return new PageResponse<>(jobsPage, pageNumber, Long.valueOf(jobs.size()));
        } catch (SchedulerException e) {
            return new FailedResponse("查询失败");
        }

    }

    /**
     * 创建一个job
     *
     * @param jobName
     * @param className
     * @param corn
     * @param jsonData  传给job的参数
     * @return Response 是否创建成功
     */
    public Response addJob(String jobName, String description, String className, String corn, String jsonData) {
        Class cls;
        try {
            cls = Class.forName(className.trim());
        } catch (ClassNotFoundException e) {
            return new FailedResponse("任务class不存在");
        }
        DynamicJob job = new DynamicJob(cls, corn, jobName);
        try {
            if (jobService.checkJobExists(job.triggerKey())) {
                return new FailedResponse("已存在名称为:" + jobName + "的任务");
            }
            job.setDescription(description);
            // 加参数
            addJsonData(job, jsonData);
            jobService.registJob(job);
        } catch (SchedulerException e) {
            return new FailedResponse("创建任务失败");
        }
        return new SuccessResponse("创建成功");
    }

    /**
     * 修改一个job
     *
     * @param jobName
     * @param className
     * @param corn
     * @return Response 是否创建成功
     */
    public Response editJob(String jobName, String description, String className, String corn, String jsonData) {
        this.removeJob(jobName, className, corn);
        this.addJob(jobName, description, className, corn, jsonData);
        return new SuccessResponse("修改成功");
    }

    /**
     * 创建一个临时job 15秒后执行
     *
     * @param className
     * @return Response 是否创建成功
     */
    public Response addTempJob(String className, String jsonData) {
        Class cls;
        try {
            cls = Class.forName(className.trim());
        } catch (ClassNotFoundException e) {
            return new FailedResponse("任务class不存在");
        }
        DynamicJob job = new DynamicJob(cls, DateUtils.addSeconds(new Date(), 20));
        try {
            if (jobService.checkJobExists(job.triggerKey())) {
                return new FailedResponse("已存在名称为:" + job.getJobName() + "的任务");
            }
            addJsonData(job, jsonData);
            jobService.registJob(job);
        } catch (SchedulerException e) {
            return new FailedResponse("执行失败");
        }
        return new SuccessResponse("操作成功，job将在15秒后执行...");
    }

    /**
     * 给job加上自定义的参数
     *
     * @param job
     * @param jsonData
     * @return
     */
    public void addJsonData(DynamicJob job, String jsonData) {
        if (StringUtils.isNotBlank(jsonData)) {
            Map mapData = JSON.parseObject(jsonData);
            for (Object obj : mapData.entrySet()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) obj;
                job.addJobData(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 暂停一个任务
     *
     * @param jobName
     * @return Response 成功or失败
     */
    public Response pauseJob(String jobName, String className, String cronExpression) {
        Class jobClass = null;
        try {
            jobClass = Class.forName(className.trim());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new FailedResponse("类名不存在");
        }
        DynamicJob job = new DynamicJob(jobClass, cronExpression, jobName);
        try {
            jobService.pauseJob(job);
        } catch (SchedulerException e) {
            return new FailedResponse("暂停失败");
        }
        return new SuccessResponse("暂停成功");
    }

    /**
     * 删除一个任务
     *
     * @param jobName
     * @return Response 成功or失败
     */
    public Response removeJob(String jobName, String className, String cronExpression) {
        Class jobClass = null;
        try {
            jobClass = Class.forName(className.trim());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new FailedResponse("类名不存在");
        }
        DynamicJob job = new DynamicJob(jobClass, cronExpression, jobName);
        try {
            jobService.removeJob(job);
        } catch (SchedulerException e) {
            return new FailedResponse("删除失败");
        }
        return new SuccessResponse("删除成功");
    }

    /**
     * 重新启动一个任务
     *
     * @param jobName
     * @return Response 成功or失败
     */
    public Response resumeJob(String jobName, String className, String cronExpression) {
        Class jobClass = null;
        try {
            jobClass = Class.forName(className.trim());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new FailedResponse("类名不存在");
        }
        DynamicJob job = new DynamicJob(jobClass, cronExpression, jobName);
        try {
            jobService.resumeJob(job);
        } catch (SchedulerException e) {
            return new FailedResponse("启动失败");
        }
        return new SuccessResponse("启动成功");
    }
}
