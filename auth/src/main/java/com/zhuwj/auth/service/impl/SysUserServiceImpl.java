package com.zhuwj.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.mapper.SysUserMapper;
import com.zhuwj.auth.service.ISysUserService;
import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private final SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUuid(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new BusinessException(ErrorCodeEnum.REQUIRED_PARAMETER_FOR_THE_REQUEST_IS_EMPTY);
        }
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uuid", uuid);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (sysUser == null) {
            throw new BusinessException(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        return sysUser;
    }

    @Override
    public SysUser findByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            throw new BusinessException(ErrorCodeEnum.REQUIRED_PARAMETER_FOR_THE_REQUEST_IS_EMPTY);
        }
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (sysUser == null) {
            throw new BusinessException(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        return sysUser;
    }


}
