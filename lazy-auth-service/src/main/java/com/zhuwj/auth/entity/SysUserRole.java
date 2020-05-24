package com.zhuwj.auth.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUserRole extends Model<SysUserRole> {


    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;


}
