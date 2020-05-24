package com.zhuwj.auth.rest;


import com.zhuwj.auth.service.SysUserRoleService;
import com.zhuwj.common.base.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/sys-user-role")
@RequiredArgsConstructor
@Slf4j
public class SysUserRoleController extends BaseController {

    private final SysUserRoleService sysUserRoleService;


}
