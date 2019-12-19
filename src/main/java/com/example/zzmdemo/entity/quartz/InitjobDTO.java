package com.example.zzmdemo.entity.quartz;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author chenhao
 * @ Description job定时任务可视化显示内容
 * @ date Create in 15:25 2018/7/23
 */
@Data
@Accessors(chain = true)
public class InitjobDTO {
    /***/
    private String key;
    /***
     * 任务名称.
     */
    private String jobName;
    /***
     * 任务描述.
     */
    private String description;
    /***
     * 规则类名.
     */
    private String className;
    /***
     * 执行策略.
     */
    private String cronExpression;
    /***
     * 下次执行时间.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date nextFireTime;
    /***
     * 状态.
     */
    private String state;
    /***
     * job参数.
     */
    private String jsonData;


}
