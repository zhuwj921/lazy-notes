package com.zhuwj.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuwj.auth.entity.SysResource;
import com.zhuwj.auth.entity.SysRoleResource;
import com.zhuwj.auth.mapper.SysResourceMapper;
import com.zhuwj.auth.service.SysResourceService;
import com.zhuwj.auth.service.SysRoleResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RequiredArgsConstructor
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    private final SysRoleResourceService sysRoleResourceService;

    @Override
    public List<SysResource> listByRoleIds(List<Long> roleIds) {
        QueryWrapper sysRoleResourceWrapper = new QueryWrapper();
        sysRoleResourceWrapper.in("role_id",roleIds);
        List<SysRoleResource> sysRoleResourceList = sysRoleResourceService.list(sysRoleResourceWrapper);
        Set<Long> resourceIdList = sysRoleResourceList.stream().map(SysRoleResource::getResourceId).collect(Collectors.toSet());
        List<SysResource> sysResourceList = baseMapper.selectBatchIds(resourceIdList);
        return sysResourceList;
    }
}
