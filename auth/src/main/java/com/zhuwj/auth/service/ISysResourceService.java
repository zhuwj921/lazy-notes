package com.zhuwj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuwj.auth.entity.SysResource;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-19
 */
public interface ISysResourceService extends IService<SysResource> {

    List<SysResource> findResourceByRoleId(Set<Integer> roleIds);

    List<SysResource> findResourceByUsername(String username);

    List<SysResource> findResourceByUserId(Integer id);
}
