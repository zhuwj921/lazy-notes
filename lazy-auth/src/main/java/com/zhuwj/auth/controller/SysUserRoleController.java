package com.zhuwj.auth.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuwj.auth.base.BaseController;
import com.zhuwj.auth.entity.SysUserRole;
import com.zhuwj.auth.model.dto.UserRoleDTO;
import com.zhuwj.auth.service.ISysUserRoleService;
import com.zhuwj.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 关系表用户角色 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController extends BaseController {


    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @PostMapping
    public ResponseResult setUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        Set<Integer> roleIds = userRoleDTO.getRoleIds();
        Integer userId = userRoleDTO.getUserId();

        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        sysUserRoleService.remove(wrapper);

        List<SysUserRole> list = new ArrayList<>();
        for(Integer roleId : roleIds){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.init();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(userId);
            list.add(sysUserRole);
        }
        return ResponseResult.ok(sysUserRoleService.saveBatch(list));
    }


}
