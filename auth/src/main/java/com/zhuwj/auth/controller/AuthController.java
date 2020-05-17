package com.zhuwj.auth.controller;

import com.zhuwj.auth.config.SecurityProperties;
import com.zhuwj.auth.model.dto.SecurityUserDTO;
import com.zhuwj.auth.model.dto.UserDTO;
import com.zhuwj.auth.security.TokenProvider;
import com.zhuwj.common.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 授权控制器
 * @author: zhuwj
 * @create: 2020-05-16 18:10
 **/
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final SecurityProperties properties;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("login")
    public ResponseResult login(@RequestBody UserDTO userDTO){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);
        return ResponseResult.ok(token);
    }


    @GetMapping("user")
    @PreAuthorize("@el.check('sysAdmin')")
    public ResponseResult userInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUserDTO securityUserDTO = (SecurityUserDTO) authentication.getPrincipal();
        return ResponseResult.ok(securityUserDTO);
    }
}
