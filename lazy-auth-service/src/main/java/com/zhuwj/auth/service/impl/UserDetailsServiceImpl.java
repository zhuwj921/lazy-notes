package com.zhuwj.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.service.SysUserService;
import com.zhuwj.common.exception.BusinessException;
import com.zhuwj.common.security.dto.SecurityUserDTO;
import com.zhuwj.common.security.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 用户信息实现类
 * @author: zhuwj
 * @create: 2020-05-24 14:21
 **/
@Slf4j
@Service("userDetailsService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser;
        try {
            sysUser = sysUserService.findByUsername(s);
        } catch (BusinessException e) {
            throw new UsernameNotFoundException("username not found", e);
        }

        UserDTO userDTO = new UserDTO();
        BeanUtil.copyProperties(sysUser,userDTO);
        List<String> authoritieList =sysUserService.getAllPermissCodeByUserId(userDTO.getId());
        List<GrantedAuthority> authorities = authoritieList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new SecurityUserDTO(userDTO, authorities);
    }
}
