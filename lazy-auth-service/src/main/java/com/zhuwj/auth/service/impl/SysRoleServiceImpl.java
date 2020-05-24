package com.zhuwj.auth.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuwj.auth.entity.SysRole;
import com.zhuwj.auth.entity.SysUserRole;
import com.zhuwj.auth.mapper.SysRoleMapper;
import com.zhuwj.auth.mapper.SysUserRoleMapper;
import com.zhuwj.auth.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RequiredArgsConstructor
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysRole> listByUserId(Long userId) {
        QueryWrapper sysUserRoleWrapper = new QueryWrapper();
        sysUserRoleWrapper.eq("user_id",userId);
        List<SysUserRole> sysUserRoleList = sysUserRoleMapper.selectList(sysUserRoleWrapper);
        if(CollUtil.isEmpty(sysUserRoleList)){
            return CollUtil.newArrayList();
        }
        List<Long> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRole> sysRoleList = baseMapper.selectBatchIds(roleIdList);
        return sysRoleList;
    }
}
