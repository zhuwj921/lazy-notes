package com.zhuwj.auth.controller;


import com.zhuwj.auth.model.dto.UserRoleDTO;
import com.zhuwj.auth.service.ISysUserRoleService;
import com.zhuwj.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.zhuwj.auth.base.BaseController;

import java.util.Set;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController extends BaseController {

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    public ResponseResult setUserRole(@RequestBody UserRoleDTO userRoleDTO){
        Integer userId = userRoleDTO.getUserId();
        Set<Integer> roleIds = userRoleDTO.getRoleIds();
        return ResponseResult.ok();
    }


}
