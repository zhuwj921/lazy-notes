package com.zhuwj.auth.rest;

import com.zhuwj.auth.security.TokenProvider;
import com.zhuwj.common.response.ResponseResult;
import com.zhuwj.common.security.dto.SecurityUserDTO;
import com.zhuwj.common.security.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 授权控制器
 * @author: zhuwj
 * @create: 2020-05-24 15:44
 **/
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * 授权登入
     * @param userDTO
     * @return
     */
    @PostMapping("login")
    public ResponseResult login(@RequestBody UserDTO userDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);
        return ResponseResult.ok(token);
    }

    /**
     * 用户信息
     * @return
     */
    //    @PreAuthorize("@el.check('sysAdmin')")
    @GetMapping("user")
    public ResponseResult userInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUserDTO securityUserDTO = (SecurityUserDTO) authentication.getPrincipal();
        return ResponseResult.ok(securityUserDTO);
    }
}
