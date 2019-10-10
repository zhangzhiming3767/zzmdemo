package com.example.zzmdemo.core.quartz;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.*;

import java.util.Date;

/**
 * 一个动态的 job 信息.
 *
 * @author pzy
 */
public class DynamicJob {


    /**
     * 具体执行job的class.
     */
    @Getter
    @Setter
    private Class<? extends Job> target;

    /**.
     * cron 表达式  不懂怎么写cron的同学 可以参考 http://www.pppet.net
     */
    @Getter
    @Setter
    private String cronExpression;
    /***/
    @Getter
    @Setter
    private String jobGroup = Scheduler.DEFAULT_GROUP;

    /**
     * 任务名称，唯一.
     */
    @Getter
    @Setter
    private String jobName;
    /**
     * 任务描述.
     */
    @Getter
    @Setter
    private String description;
    /***/
    private transient TriggerKey triggerKey;
    /***/
    private transient JobDetail jobDetail;
    /***/
    public DynamicJob() {
    }

    /**
     *
     * @param target target
     * @param cronExpression cronExpression
     */
    public DynamicJob(final Class<? extends Job> target,
                      final String cronExpression) {
        super();
        this.target = target;
        this.jobName = java.util.UUID.randomUUID().toString();
        this.cronExpression = cronExpression;
    }

    /**
     *
     * @param target target
     * @param runAt runAt
     */
    public DynamicJob(final Class<? extends Job> target, final Date runAt) {
        super();
        this.target = target;
        this.cronExpression
                = DateFormatUtils.format(runAt, "ss mm HH dd MM ? yyyy");
        this.jobName = java.util.UUID.randomUUID().toString();
    }
    /**
     *
     * @param target target
     * @param runAt runAt
     * @param jobName jobName
     */
    public DynamicJob(final Class<? extends Job> target,
                      final Date runAt, final String jobName) {
        super();
        this.target = target;
        this.cronExpression
                = DateFormatUtils.format(runAt, "ss mm HH dd MM ? yyyy");
        this.jobName = jobName;
    }

    /**
     *
     * @param target target
     * @param  cronExpression cronExpression
     * @param jobName jobName
     */
    public DynamicJob(final Class<? extends Job> target,
                      final String cronExpression,
                      final String jobName) {
        super();
        this.target = target;
        this.cronExpression = cronExpression;
        this.jobName = jobName;
    }

    /**
     *
     * @return TriggerKey
     */
    public TriggerKey triggerKey() {
        if (triggerKey == null) {
            triggerKey = TriggerKey.triggerKey(this.jobName, this.jobGroup);
        }
        return triggerKey;
    }

    /**
     *
     * @return JobDetail
     */
    public JobDetail jobDetail() {
        if (jobDetail == null) {
            jobDetail = JobBuilder.newJob(target)
                    .withIdentity(this.jobName, this.jobGroup)
                    .withDescription(this.description)
                    .build();
        }
        return jobDetail;
    }

    /**
     * 传参数给 执行的 job.
     * 在job中 通过
     * context.getMergedJobDataMap().get(key) 获取值
     * @param key key
     * @param value value
     * @return DynamicJob
     */
    public DynamicJob addJobData(final String key, final Object value) {
        final JobDetail detail = jobDetail();
        final JobDataMap jobDataMap = detail.getJobDataMap();
        jobDataMap.put(key, value);
        return this;
    }

    /**
     *
     * @return CronTrigger
     */
    public CronTrigger getCronTrigger() {
        final CronScheduleBuilder cronScheduleBuilder
                = CronScheduleBuilder.cronSchedule(this.cronExpression);
        return TriggerBuilder.newTrigger().withIdentity(triggerKey())
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
