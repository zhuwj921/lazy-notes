package com.zhuwj.dict.rest;


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
import com.zhuwj.dict.entity.DictDetail;
import com.zhuwj.dict.service.DictDetailService;

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
@RequestMapping("/dict-detail")
@RequiredArgsConstructor
@Slf4j
public class DictDetailController extends BaseController {

    private final DictDetailService dictDetailService;

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
        IPage result = dictDetailService.page(page,wrapper);
        return ResponseResult.ok(result);
    }

    /**
    * 根据ID查找数据
    * @param id
    */
    @GetMapping("{id}")
    public ResponseResult find(@PathVariable("id") Long id){
        DictDetail result = dictDetailService.getById(id);
        return ResponseResult.ok(result);
    }

    /**
    * 保存数据
    * @param dictDetail
    */
    @PostMapping
    public ResponseResult save(@RequestBody DictDetail dictDetail){
        dictDetail.init();
        dictDetailService.save(dictDetail);
        return ResponseResult.ok();
    }

    /**
    * 修改数据
    * @param dictDetail
    */
    @PutMapping
    public ResponseResult update(@RequestBody DictDetail dictDetail) {

        DictDetail result = dictDetailService.getById(dictDetail.getId());
        if(result == null){
            return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
         }
        dictDetail.modify(result);
        dictDetailService.updateById(dictDetail);
        return ResponseResult.ok();
    }

    /**
    * 根据id删除数据
    * @param id
    */
    @DeleteMapping("{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        DictDetail result = dictDetailService.getById(id);
        if(result == null){
          return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        dictDetailService.removeById(id);
        return ResponseResult.ok();
    }
}
