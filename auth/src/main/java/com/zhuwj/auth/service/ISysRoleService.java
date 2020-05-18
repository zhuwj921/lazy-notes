package com.zhuwj.auth.service;

import com.zhuwj.auth.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
public interface ISysRoleService extends IService<SysRole> {

    SysRole findByUuid(String uuid);

}
