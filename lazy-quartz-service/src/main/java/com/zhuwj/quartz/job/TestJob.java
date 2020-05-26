package com.zhuwj.quartz.job;

import cn.hutool.core.date.DateUtil;
import com.zhuwj.quartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("test job run {}" , DateUtil.now());
    }
}
