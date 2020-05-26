package com.zhuwj.quartz.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuwj.quartz.entity.JobAndTrigger;
import org.springframework.stereotype.Repository;

/**
 * Description: job mapper
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */

@Repository
public interface JobMapper {
    /**
     * 查询定时任务列表
     * @param wrapper
     * @return
     */
    IPage<JobAndTrigger> selectPage(Page<?> page, QueryWrapper wrapper);

}
