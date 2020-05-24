package com.zhuwj.auth.config;

import com.zhuwj.common.constant.GlobalConstant;
import com.zhuwj.common.util.WebContextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

/**
 * @description: 权限检查配置
 * @author: zhuwj
 * @create: 2020-05-16 20:01
 **/
@Service("el")
@RequiredArgsConstructor
public class ElPermissionConfig {

    /**
     * 校验是否存在权限
     *
     * @param permissions
     * @return
     */
    public Boolean check(String... permissions) {
        Set<String> elPermissions = WebContextUtil.getCurrentSecurityUser().getResources();
        return elPermissions.contains(GlobalConstant.SYS_ADMIN) || Arrays.stream(permissions).anyMatch(elPermissions::contains);
    }
}
