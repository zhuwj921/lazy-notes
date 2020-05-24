package com.zhuwj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuwj.auth.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> listByUserId(Long userId);

}
