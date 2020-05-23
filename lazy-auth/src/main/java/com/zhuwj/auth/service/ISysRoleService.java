package com.zhuwj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuwj.auth.entity.SysRole;

import java.util.List;
import java.util.Set;

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


    List<SysRole> findByRoleIds(Set<Integer> roleIds);

}
