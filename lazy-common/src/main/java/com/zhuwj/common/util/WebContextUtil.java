package com.zhuwj.common.util;

import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.exception.AuthException;
import com.zhuwj.common.security.dto.SecurityUserDTO;
import com.zhuwj.common.security.dto.UserDTO;
import lombok.experimental.UtilityClass;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @description: 获取当前上下文用户请求信息
 * @author: zhuwj
 * @create: 2020-05-16 18:10
 **/
@UtilityClass
public class WebContextUtil {

    /**
     * 获取当前上下文授权信息
     *
     * @return
     */
    public Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication;
        }
        throw new AuthException(ErrorCodeEnum.UNAUTHORIZED_ACCESS);
    }

    /**
     * 获取用户
     */
    public SecurityUserDTO getCurrentUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUserDTO) {
            return (SecurityUserDTO) principal;
        }
        throw new AuthException(ErrorCodeEnum.UNAUTHORIZED_ACCESS);
    }

    /**
     * 获取security用户
     */
    public SecurityUserDTO getCurrentSecurityUser() {
        Authentication authentication = getAuthentication();
        return getCurrentUser(authentication);
    }

    /**
     * 获取用户信息对象
     *
     * @return
     */
    public UserDTO getUser() {
        return WebContextUtil.getCurrentSecurityUser().getUser();
    }


}
