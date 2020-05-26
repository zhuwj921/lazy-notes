package com.zhuwj.quartz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuwj.quartz.entity.JobAndTrigger;
import com.zhuwj.quartz.entity.JobDO;
import org.quartz.SchedulerException;

/**
 * Description: job接口
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */

public interface JobService {

    /**
     * 添加并启动定时任务
     *
     * @param jobDO
     * @throws Exception 异常
     */
    void addJob(JobDO jobDO) throws Exception;

    /**
     * 删除定时任务
     *
     * @param jobDO
     * @throws SchedulerException 异常
     */
    void deleteJob(JobDO jobDO) throws SchedulerException;

    /**
     * 暂停定时任务
     *
     * @param jobDO
     * @throws SchedulerException 异常
     */
    void pauseJob(JobDO jobDO) throws SchedulerException;

    /**
     * 恢复定时任务
     *
     * @param jobDO 表单参数 {@link JobDO}
     * @throws SchedulerException 异常
     */
    void resumeJob(JobDO jobDO) throws SchedulerException;

    /**
     * 重新配置定时任务
     *
     * @param jobDO
     * @throws Exception 异常
     */
    void cronJob(JobDO jobDO) throws Exception;

    /**
     * 查询定时任务列表
     * @param wrapper
     * @return
     */
    IPage<JobAndTrigger> page(Page<JobAndTrigger> page, QueryWrapper wrapper);
}
