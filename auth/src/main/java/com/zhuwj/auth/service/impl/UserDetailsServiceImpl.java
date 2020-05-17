package com.zhuwj.auth.service.impl;

import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.model.dto.SecurityUserDTO;
import com.zhuwj.auth.model.dto.UserDTO;
import com.zhuwj.auth.service.ISysUserService;
import com.zhuwj.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: UserDetailsServiceImpl
 * @description: 用户信息实现类
 * @author: zhuwj
 * @create: 2020-05-16 16:41
 **/

@Slf4j
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public SecurityUserDTO loadUserByUsername(String s){
        SysUser sysUser;
        try {
             sysUser = sysUserService.findByUsername(s);
        } catch (BusinessException e) {
            throw new UsernameNotFoundException("username not found",e);
        }

        UserDTO userDTO = new UserDTO();
        userDTO.init(sysUser);
        List<String> authoritieList = Arrays.asList("sysAdmin");
        List authorities = authoritieList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new SecurityUserDTO(userDTO,authorities);
    }
}
