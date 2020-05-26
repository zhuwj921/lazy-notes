package com.zhuwj.quartz.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description: Job对象
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */
@Data
@Accessors(chain = true)
public class JobDO {

    /**
     * 定时任务全类名
     */
    private String jobClassName;
    /**
     * 任务组名
     */
    private String jobGroupName;
    /**
     * 定时任务cron表达式
     */
    private String cronExpression;
}
