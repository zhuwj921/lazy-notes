package com.zhuwj.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuwj.auth.entity.SysRole;
import com.zhuwj.auth.mapper.SysRoleMapper;
import com.zhuwj.auth.service.ISysRoleService;
import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {


    @Override
    public SysRole findByUuid(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new BusinessException(ErrorCodeEnum.REQUIRED_PARAMETER_FOR_THE_REQUEST_IS_EMPTY);
        }
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uuid", uuid);
        SysRole sysRole = baseMapper.selectOne(queryWrapper);
        if (sysRole == null) {
            throw new BusinessException(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        return sysRole;
    }
}
