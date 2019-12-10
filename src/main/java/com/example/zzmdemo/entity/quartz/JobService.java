package com.example.zzmdemo.entity.quartz;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ChenHao
 * @ Description job动态处理
 * @ date 2018/7/23
 */
@Service
public class JobService {
    /***/
    @Autowired
    private Scheduler scheduler;
    /***/
    private static final Logger LOGGER
            = LoggerFactory.getLogger(JobService.class);

    /**
     *
     * @param name name
     * @param stateName stateName
     * @return List<InitjobDTO>
     * @throws SchedulerException SchedulerException
     */
    public List<InitjobDTO> queryJobs(final String name,
                                      final String stateName
    ) throws SchedulerException {
        List<InitjobDTO> initjobDTOs = new ArrayList<>();
        for (String groupName : scheduler.getJobGroupNames()) {
            for (JobKey jobKey : scheduler.getJobKeys(
                    GroupMatcher.jobGroupEquals(groupName))) {
                InitjobDTO initjobDTO = new InitjobDTO();
                String className = scheduler.getJobDetail(jobKey)
                        .getJobClass().getName();
                String description
                        = scheduler.getJobDetail(jobKey).getDescription();
                String jobName = jobKey.getName();
                //查出触发器
                List<Trigger> triggers
                        = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                Date nextFireTime = triggers.get(0).getNextFireTime();
                TriggerKey triggerKey = triggers.get(0).getKey();
                Trigger.TriggerState triggerState
                        = scheduler.getTriggerState(triggerKey);
                String jsonData = JSON.toJSONString(
                        scheduler.getJobDetail(jobKey).getJobDataMap());
                String state = triggerState.toString();
                //统一使用 CronTrigger
                CronTrigger cronTrigger = (CronTrigger) triggers.get(0);
                String cronExpression = cronTrigger.getCronExpression();
                initjobDTO.setClassName(className);
                initjobDTO.setDescription(description);
                initjobDTO.setJobName(jobName);
                initjobDTO.setState(state);
                initjobDTO.setNextFireTime(nextFireTime);
                initjobDTO.setCronExpression(cronExpression);
                initjobDTO.setKey(String.valueOf(jobKey));
                initjobDTO.setJsonData(jsonData);
                if (StringUtils.isBlank(name)
                        && StringUtils.isBlank(stateName)) {
                    initjobDTOs.add(initjobDTO);
                } else if (!StringUtils.isBlank(name)
                        && !StringUtils.isBlank(stateName)) {
                    if (jobName.contains(name)
                            && StringUtils.equals(state, stateName)) {
                        initjobDTOs.add(initjobDTO);
                    }
                } else if (!StringUtils.isBlank(name)
                        && jobName.contains(name)) {
                    initjobDTOs.add(initjobDTO);
                } else if (!StringUtils.isBlank(stateName)
                        && StringUtils.equals(state, stateName)) {
                    initjobDTOs.add(initjobDTO);
                }


            }

        }
        return initjobDTOs;
    }

    /***
     * 注册一个job.
     * @param dynamicJob dynamicJob
     * @throws SchedulerException SchedulerException
     */
    public void registJob(final DynamicJob dynamicJob)
            throws SchedulerException {
        if (checkJobExists(dynamicJob.triggerKey())) {
            scheduler.resumeTrigger(dynamicJob.triggerKey());
            LOGGER.warn("===> AddJob fail, job already exist jobName:{}",
                    dynamicJob.getJobName()
            );
        } else {
            scheduler.scheduleJob(
                    dynamicJob.jobDetail(), dynamicJob.getCronTrigger()
            );
            LOGGER.debug("创建任务:{}", dynamicJob.getJobName());
        }
    }

    /**
     * 暂停一个job.
     *
     * @param job job
     * @throws SchedulerException SchedulerException
     */
    public void pauseJob(final DynamicJob job)
            throws SchedulerException {
        if (!scheduler.isShutdown()) {
            scheduler.pauseJob(job.jobDetail().getKey());
            scheduler.pauseTrigger(job.triggerKey());
            LOGGER.debug("暂停任务:{}", job.getJobName());
        }
    }

    /**.
     * @param job job
     * @throws SchedulerException SchedulerException
     * @Description: 移除一个job
     */
    public void removeJob(final DynamicJob job) throws SchedulerException {
        pauseJob(job);
        scheduler.unscheduleJob(job.triggerKey());
        // 删除任务
        scheduler.deleteJob(job.jobDetail().getKey());
        LOGGER.debug("移除任务:{}", job.getJobName());
    }

    /**
     * 启动一个job.
     *
     * @param job job
     * @throws SchedulerException SchedulerException
     */
    public void resumeJob(final DynamicJob job) throws SchedulerException {
        if (!scheduler.isShutdown()) {
            scheduler.resumeJob(job.jobDetail().getKey());
            scheduler.resumeTrigger(job.triggerKey());
            LOGGER.debug("启动任务:{}", job.getJobName());
        }
    }


    /***
     * 检查job是否存在.
     * @param triggerKey triggerKey
     * @return boolean
     * @throws SchedulerException SchedulerException
     */
    public boolean checkJobExists(final TriggerKey triggerKey)
            throws SchedulerException {
        return scheduler.checkExists(triggerKey);
    }
}
