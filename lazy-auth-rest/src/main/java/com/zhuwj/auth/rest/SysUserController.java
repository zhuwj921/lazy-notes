package com.zhuwj.auth.rest;


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
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.service.SysUserService;

import org.springframework.web.bind.annotation.RestController;
import com.zhuwj.common.base.BaseController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/sys-user")
@RequiredArgsConstructor
@Slf4j
public class SysUserController extends BaseController {

    private final SysUserService sysUserService;

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
        IPage result = sysUserService.page(page,wrapper);
        return ResponseResult.ok(result);
    }

    /**
    * 根据ID查找数据
    * @param id
    */
    @GetMapping("{id}")
    public ResponseResult find(@PathVariable("id") Long id){
        SysUser result = sysUserService.getById(id);
        return ResponseResult.ok(result);
    }

    /**
    * 保存数据
    * @param sysUser
    */
    @PostMapping
    public ResponseResult save(@RequestBody SysUser sysUser){
        sysUser.init();
        sysUserService.save(sysUser);
        return ResponseResult.ok();
    }

    /**
    * 修改数据
    * @param sysUser
    */
    @PutMapping
    public ResponseResult update(@RequestBody SysUser sysUser) {

        SysUser result = sysUserService.getById(sysUser.getId());
        if(result == null){
            return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
         }
        sysUser.modify(result);
        sysUserService.updateById(sysUser);
        return ResponseResult.ok();
    }

    /**
    * 根据id删除数据
    * @param id
    */
    @DeleteMapping("{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        SysUser result = sysUserService.getById(id);
        if(result == null){
          return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        sysUserService.removeById(id);
        return ResponseResult.ok();
    }
}
