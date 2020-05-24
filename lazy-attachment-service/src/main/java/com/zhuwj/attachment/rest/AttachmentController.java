package com.zhuwj.attachment.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.zhuwj.common.response.ResponseResult;
import java.util.Map;
import com.zhuwj.common.enums.ErrorCodeEnum;
import org.springframework.web.bind.annotation.*;
import com.zhuwj.attachment.entity.Attachment;
import com.zhuwj.attachment.service.AttachmentService;

import org.springframework.web.bind.annotation.RestController;
import com.zhuwj.common.base.BaseController;

/**
 * <p>
 * 基础表 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/attachment")
@RequiredArgsConstructor
@Slf4j
public class AttachmentController extends BaseController {

    private final AttachmentService attachmentService;

    /**
    * 分页查询
    * @param pageNum
    * @param pageSize
    * @param map
    */
    @GetMapping("/page")
    public ResponseResult page(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize,Map map){
        Page page = new Page(pageNum,pageSize);
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        IPage result = attachmentService.page(page,wrapper);
        return ResponseResult.ok(result);
    }

    /**
    * 根据ID查找数据
    * @param id
    */
    @GetMapping("{id}")
    public ResponseResult find(@PathVariable("id") Long id){
        Attachment result = attachmentService.getById(id);
        return ResponseResult.ok(result);
    }

    /**
    * 保存数据
    * @param attachment
    */
    @PostMapping
    public ResponseResult save(@RequestBody Attachment attachment){
        attachment.init();
        attachmentService.save(attachment);
        return ResponseResult.ok();
    }

    /**
    * 修改数据
    * @param attachment
    */
    @PutMapping
    public ResponseResult update(@RequestBody Attachment attachment) {

        Attachment result = attachmentService.getById(attachment.getId());
        if(result == null){
            return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
         }
        attachment.modify(result);
        attachmentService.updateById(attachment);
        return ResponseResult.ok();
    }

    /**
    * 根据id删除数据
    * @param id
    */
    @DeleteMapping("{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        Attachment result = attachmentService.getById(id);
        if(result == null){
          return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        attachmentService.removeById(id);
        return ResponseResult.ok();
    }
}
