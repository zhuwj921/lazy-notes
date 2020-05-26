package com.zhuwj.quartz.entity;

/**
 * Description: TODO
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */

public class JobAndTrigger {
    /**
     * 定时任务名称
     */
    private String jobName;
    /**
     * 定时任务组
     */
    private String jobGroup;
    /**
     * 定时任务全类名
     */
    private String jobClassName;
    /**
     * 触发器名称
     */
    private String triggerName;
    /**
     * 触发器组
     */
    private String triggerGroup;
    /**
     * 重复间隔
     */
    private Long repeatInterval;
    /**
     * 触发次数
     */
    private Long timesTriggered;
    /**
     * cron 表达式
     */
    private String cronExpression;
    /**
     * 时区
     */
    private String timeZoneId;
    /**
     * 定时任务状态
     */
    private String triggerState;
}
