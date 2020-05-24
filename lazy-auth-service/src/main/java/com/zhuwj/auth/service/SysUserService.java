package com.zhuwj.auth.service;

import com.zhuwj.auth.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
public interface SysUserService extends IService<SysUser> {

    SysUser findByUsername(String username);

    List<String> getAllPermissCodeByUserId(Long userId);

    List<String> getAllPermissCodeByUsername(String username);

}
