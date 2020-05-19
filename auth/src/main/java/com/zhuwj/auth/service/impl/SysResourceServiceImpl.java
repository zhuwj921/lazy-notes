package com.zhuwj.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuwj.auth.entity.SysResource;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.entity.SysUserRole;
import com.zhuwj.auth.mapper.SysResourceMapper;
import com.zhuwj.auth.service.ISysResourceService;
import com.zhuwj.auth.service.ISysUserRoleService;
import com.zhuwj.auth.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-19
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysUserService sysUserService;

    @Override
    public List<SysResource> findResourceByRoleId(Set<Integer> roleIds) {
        List<SysResource> list = new ArrayList<>();
        QueryWrapper<SysResource> wrapper = new QueryWrapper();
        for (Integer roleId : roleIds) {
            wrapper.eq("role_id", roleId);
            list.addAll(baseMapper.selectList(wrapper));
        }
        return list;
    }

    @Override
    public List<SysResource> findResourceByUsername(String username) {
        SysUser sysUser = sysUserService.findByUsername(username);
        return findResourceByUserId(sysUser.getId());
    }

    @Override
    public List<SysResource> findResourceByUserId(Integer id) {
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        List<SysUserRole> list = sysUserRoleService.list(wrapper);
        Set<Integer> roleIds = list.stream().map(SysUserRole::getRoleId).collect(Collectors.toSet());
        return findResourceByRoleId(roleIds);
    }
}
