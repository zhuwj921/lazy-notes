package com.zhuwj.quartz.rest;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhuwj.quartz.QuartzApplication;
import com.zhuwj.quartz.entity.JobDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuartzApplication.class)
public class JobControllerTest {

    @Autowired
    private  JobController jobController;

    @Test
    public void job() throws InterruptedException {
        JobDO jobDO = new JobDO();
        Map map =new HashMap();
        jobDO.setJobClassName("com.zhuwj.quartz.job.TestJob").setJobGroupName(IdUtil.randomUUID()).setCronExpression("1-59 * * * * ? ");
        jobController.addJob(jobDO);
        Thread.sleep(5000);
        jobController.pauseJob(jobDO);
        Thread.sleep(5000);
        jobController.resumeJob(jobDO);
        Thread.sleep(5000);
        IPage result =(IPage) jobController.page(1,100,map).getResult();
        log.info("job size {}",result.getRecords().size());
        jobController.deleteJob(jobDO);
        IPage result2 =(IPage) jobController.page(1,100,map).getResult();
        log.info("delete dejob size {}",result2.getRecords().size());
        Thread.sleep(5000);
        log.info("end");
    }
}