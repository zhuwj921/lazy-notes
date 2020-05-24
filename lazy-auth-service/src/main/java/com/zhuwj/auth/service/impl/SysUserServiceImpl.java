package com.zhuwj.auth.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuwj.auth.entity.SysResource;
import com.zhuwj.auth.entity.SysRole;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.mapper.SysUserMapper;
import com.zhuwj.auth.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysRoleResourceService sysRoleResourceService;
    private final SysRoleService sysRoleService;
    private final SysUserRoleService sysUserRoleService;
    private final SysResourceService sysResourceService;


    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<String> getAllPermissCodeByUserId(Long userId) {
        List<SysRole> sysRoleList = sysRoleService.listByUserId(userId);
        List<Long> roleIdList = sysRoleList.stream().map(SysRole::getId).collect(Collectors.toList());
        if(CollUtil.isEmpty(roleIdList)){
            return CollUtil.newArrayList();
        }
        List<SysResource> sysResourceList = sysResourceService.listByIds(roleIdList);
        List<String> roleCodes = sysRoleList.stream().map(SysRole::getCode).collect(Collectors.toList());
        List<String> resourceCodes = sysResourceList.stream().map(SysResource::getCode).collect(Collectors.toList());
        roleCodes.addAll(resourceCodes);
        return roleCodes;
    }

    @Override
    public List<String> getAllPermissCodeByUsername(String username) {
        SysUser sysUser = findByUsername(username);
        return getAllPermissCodeByUserId(sysUser.getId());
    }
}
