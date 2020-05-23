package com.zhuwj.auth.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuwj.auth.entity.SysRole;
import com.zhuwj.auth.entity.SysUserRole;
import com.zhuwj.auth.service.ISysResourceService;
import com.zhuwj.auth.service.ISysRoleService;
import com.zhuwj.auth.service.ISysUserRoleService;
import com.zhuwj.auth.util.WebContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: 权限检查配置
 * @author: zhuwj
 * @create: 2020-05-16 20:01
 **/
@Service("el")
public class ElPermissionConfig {

    private static final String SYS_ADMIN = "sysAdmin";

    @Autowired
    private ISysResourceService sysResourceService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 校验是否存在权限
     *
     * @param permissions
     * @return
     */
    public Boolean check(String... permissions) {
        Set<String> elPermissions = WebContextUtil.getCurrentSecurityUser().getResources();
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", WebContextUtil.getUser().getId());
        List<SysUserRole> list = sysUserRoleService.list(wrapper);
        Set<Integer> roleIds = list.stream().map(SysUserRole::getRoleId).collect(Collectors.toSet());
        List<SysRole> roleList = sysRoleService.findByRoleIds(roleIds);
        Set<String> rolePermissions = roleList.stream().map(SysRole::getRoleName).collect(Collectors.toSet());
        return rolePermissions.contains(SYS_ADMIN) || Arrays.stream(permissions).anyMatch(elPermissions::contains);
    }
}
