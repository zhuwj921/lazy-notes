package com.zhuwj.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zhuwj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUser extends BaseEntity {


    /**
     * 用户登入账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 最新登入时间
     */
    private LocalDateTime latestTime;

    /**
     * 状态：1启用、0禁用
     */
    @TableField("is_enabled")
    private Boolean enabled;


}
