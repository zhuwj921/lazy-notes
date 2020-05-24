package com.zhuwj.auth.rest;


import com.zhuwj.auth.service.SysRoleResourceService;
import com.zhuwj.common.base.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/sys-role-resource")
@RequiredArgsConstructor
@Slf4j
public class SysRoleResourceController extends BaseController {

    private final SysRoleResourceService sysRoleResourceService;

}
