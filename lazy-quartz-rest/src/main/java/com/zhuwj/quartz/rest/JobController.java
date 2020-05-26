package com.zhuwj.quartz.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.response.ResponseResult;
import com.zhuwj.quartz.entity.JobDO;
import com.zhuwj.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Description: job前端控制器
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "job")
@RestController
public class JobController {

    private final JobService jobService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param map
     * @return
     */
    @GetMapping("/page")
    public ResponseResult page(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize, Map map) {
        Page page = new Page(pageNum, pageSize);
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        IPage result = jobService.page(page, wrapper);
        return ResponseResult.ok(result);
    }


    @PostMapping
    public ResponseResult addJob(@RequestBody JobDO jobDO){
        try {
            jobService.addJob(jobDO);
        } catch (Exception e) {
            log.error("添加job 失败",e);
            return ResponseResult.error(ErrorCodeEnum.ERROR,"添加job 失败");
        }
        return ResponseResult.ok();
    }

    @PutMapping
    public ResponseResult cronJob(@RequestBody JobDO jobDO){
        try {
            jobService.cronJob(jobDO);
        } catch (Exception e) {
            log.error("修改job 失败",e);
            return ResponseResult.error(ErrorCodeEnum.ERROR,"修改job 失败");        }
        return ResponseResult.ok();
    }

    @DeleteMapping
    public ResponseResult deleteJob(@RequestBody JobDO jobDO){
        try {
            jobService.deleteJob(jobDO);
        } catch (Exception e) {
            log.error("删除job 失败",e);
            return ResponseResult.error(ErrorCodeEnum.ERROR,"删除job 失败");        }
        return ResponseResult.ok();
    }


    @PostMapping("pause")
    public ResponseResult pauseJob(@RequestBody JobDO jobDO){
        try {
            jobService.pauseJob(jobDO);
        } catch (Exception e) {
            log.error("暂停job 失败",e);
            return ResponseResult.error(ErrorCodeEnum.ERROR,"暂停job 失败");        }
        return ResponseResult.ok();
    }

    @PostMapping("resume")
    public ResponseResult resumeJob(@RequestBody JobDO jobDO){
        try {
            jobService.resumeJob(jobDO);
        } catch (Exception e) {
            log.error("恢复job 失败",e);
            return ResponseResult.error(ErrorCodeEnum.ERROR,"恢复job 失败");        }
        return ResponseResult.ok();
    }

}
