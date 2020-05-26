package com.zhuwj.quartz.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuwj.quartz.job.base.BaseJob;
import com.zhuwj.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description: 测试job
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */
@Slf4j
@Component
public class TestJob implements BaseJob {

    @Autowired
    private  JobService jobService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Page page = new Page(1, 1);
        QueryWrapper wrapper = new QueryWrapper<>();
        log.info("test job run {}" , jobService.page(page,wrapper).toString());
    }
}
