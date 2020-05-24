package com.zhuwj.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuwj.auth.entity.SysResource;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
public interface SysResourceService extends IService<SysResource> {

    List<SysResource> listByRoleIds(List<Long> roleIds);
}
