package com.zhuwj.auth.controller;


import com.zhuwj.auth.base.BaseController;
import com.zhuwj.auth.entity.SysUser;
import com.zhuwj.auth.service.ISysUserService;
import com.zhuwj.auth.util.PasswordEncodeUtil;
import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.exception.BusinessException;
import com.zhuwj.common.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统用户前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping
    public ResponseResult save(@RequestBody SysUser sysUser) {
        if (StringUtils.isBlank(sysUser.getPassword())) {
            throw new BusinessException(ErrorCodeEnum.REQUIRED_PARAMETER_FOR_THE_REQUEST_IS_EMPTY);
        }
        sysUser.setPassword(PasswordEncodeUtil.encode(sysUser.getPassword()));
        sysUser.init();
        return ResponseResult.ok(sysUserService.save(sysUser));
    }

    @GetMapping("{uuid}")
    public ResponseResult findUser(@PathVariable("uuid") String uuid) {
        return ResponseResult.ok(sysUserService.findByUuid(uuid));
    }

    @PutMapping
    public ResponseResult update(@RequestBody SysUser sysUser) {
        SysUser queryResult = sysUserService.findByUuid(sysUser.getUuid());
        sysUser.modify(queryResult);
        return ResponseResult.ok(sysUserService.updateById(sysUser));
    }

    @PatchMapping("password")
    public ResponseResult updatePassword(@RequestBody SysUser sysUser) {
        SysUser queryResult = sysUserService.findByUuid(sysUser.getUuid());
        String password = sysUser.getPassword();
        if (StringUtils.isBlank(password)) {
            throw new BusinessException(ErrorCodeEnum.REQUIRED_PARAMETER_FOR_THE_REQUEST_IS_EMPTY);
        }
        String decordPassword = PasswordEncodeUtil.encode(password);
        sysUser.setPassword(decordPassword);
        sysUser.modify(queryResult);
        return ResponseResult.ok(sysUserService.updateById(sysUser));
    }

    @DeleteMapping
    public ResponseResult delete(@RequestBody SysUser sysUser) {
        SysUser queryResult = sysUserService.findByUuid(sysUser.getUuid());
        return ResponseResult.ok(sysUserService.removeById(queryResult.getId()));
    }

    @PatchMapping("enabled")
    public ResponseResult enabledUser(@RequestBody SysUser sysUser) {
        SysUser queryResult = sysUserService.findByUuid(sysUser.getUuid());
        sysUser.modify(queryResult);
        return ResponseResult.ok(sysUserService.updateById(sysUser));
    }


}
