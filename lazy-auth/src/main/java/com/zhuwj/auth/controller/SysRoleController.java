package com.zhuwj.auth.controller;


import com.zhuwj.auth.entity.SysRole;
import com.zhuwj.auth.service.ISysRoleService;
import com.zhuwj.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zhuwj.auth.base.BaseController;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/sys-role")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService sysRoleService;

    @PostMapping
    public ResponseResult save(@RequestBody SysRole sysRole) {
        sysRole.init();
        return ResponseResult.ok(sysRoleService.save(sysRole));
    }

    @PutMapping
    public ResponseResult update(@RequestBody SysRole sysRole) {
        SysRole queryResult = sysRoleService.findByUuid(sysRole.getUuid());
        sysRole.modify(queryResult);
        return ResponseResult.ok(sysRoleService.updateById(sysRole));
    }

    @GetMapping("{uuid}")
    public ResponseResult findRole(@PathVariable("uuid") String uuid) {
        return ResponseResult.ok(sysRoleService.findByUuid(uuid));
    }

    @DeleteMapping
    public ResponseResult delete(@RequestBody SysRole sysRole){
        SysRole queryResult = sysRoleService.findByUuid(sysRole.getUuid());
        return ResponseResult.ok(sysRoleService.removeById(queryResult.getId()));
    }

}
