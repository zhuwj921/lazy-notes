package com.zhuwj.auth.service;

import com.zhuwj.auth.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
public interface ISysUserService extends IService<SysUser> {

    SysUser findByUuid(String uuid);

    SysUser findByUsername(String username);

}
