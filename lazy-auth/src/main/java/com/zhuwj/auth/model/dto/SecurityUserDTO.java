package com.zhuwj.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @title: 权限用户对象
 * @description: 实现权限用户信息
 * @author: zhuwj
 * @create: 2020-05-16 16:29
 **/
@Getter
@AllArgsConstructor
public class SecurityUserDTO implements UserDetails {

    private final UserDTO user;

    @JsonIgnore
    private final List<GrantedAuthority> authorities;


    public Set<String> getResources() {
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }


    @Override
    @JsonIgnore
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return user.getUsername();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
