package com.zhuwj.quartz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuwj.quartz.entity.JobAndTrigger;
import com.zhuwj.quartz.entity.JobDO;
import com.zhuwj.quartz.job.util.JobUtil;
import com.zhuwj.quartz.mapper.JobMapper;
import com.zhuwj.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

/**
 * Description: job实现类
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    private final Scheduler scheduler;

    private final JobMapper jobMapper;

    @Override
    public void addJob(JobDO jobDO) throws Exception {
        // 启动调度器
        scheduler.start();

        // 构建Job信息
        JobDetail jobDetail = JobBuilder.newJob(JobUtil.getClass(jobDO.getJobClassName()).getClass()).withIdentity(jobDO.getJobClassName(), jobDO.getJobGroupName()).build();

        // Cron表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(jobDO.getCronExpression());

        //根据Cron表达式构建一个Trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobDO.getJobClassName(), jobDO.getJobGroupName()).withSchedule(cron).build();

        scheduler.scheduleJob(jobDetail, trigger);

    }

    @Override
    public void deleteJob(JobDO jobDO) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobDO.getJobClassName(), jobDO.getJobGroupName()));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobDO.getJobClassName(), jobDO.getJobGroupName()));
        scheduler.deleteJob(JobKey.jobKey(jobDO.getJobClassName(), jobDO.getJobGroupName()));
    }

    @Override
    public void pauseJob(JobDO jobDO) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobDO.getJobClassName(), jobDO.getJobGroupName()));

    }

    @Override
    public void resumeJob(JobDO jobDO) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(jobDO.getJobClassName(), jobDO.getJobGroupName()));

    }

    @Override
    public void cronJob(JobDO jobDO) throws Exception {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobDO.getJobClassName(), jobDO.getJobGroupName());
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobDO.getCronExpression());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 根据Cron表达式构建一个Trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    @Override
    public IPage<JobAndTrigger> page(Page<JobAndTrigger> page, QueryWrapper wrapper) {
        return jobMapper.selectPage(page, wrapper);

    }


}
