package com.zhuwj.auth.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@Data
@Accessors(chain = true)
public class SysUserRole extends Model<SysUserRole> {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;


}
