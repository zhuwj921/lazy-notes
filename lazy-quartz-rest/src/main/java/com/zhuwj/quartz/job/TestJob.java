package com.zhuwj.quartz.job;

import com.zhuwj.quartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * @description: 测试job
 * @author: zhuwj
 * @create: 2020-05-25 22:20
 **/
@Slf4j
@Component
public class TestJob implements BaseJob {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("TestJob run");
    }
}
