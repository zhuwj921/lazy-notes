package com.zhuwj.auth.config;

import com.zhuwj.auth.util.WebContextUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description: 权限检查配置
 * @author: zhuwj
 * @create: 2020-05-16 20:01
 **/
@Service("el")
public class ElPermissionConfig {

    private static final String SYS_ADMIN = "sysAdmin";

    public Boolean check(String... permissions) {
        // 获取当前用户的角色
        Set<String> elPermissions = WebContextUtil.getCurrentSecurityUser().getRoles();
        // 当前用户的数据权限
        Set<String> dataScopes = new HashSet<>();
        elPermissions.addAll(dataScopes);
        // 判断当前用户的所有权限是否包含接口上定义的权限
        return elPermissions.contains(SYS_ADMIN) || Arrays.stream(permissions).anyMatch(elPermissions::contains);
    }
}
