package com.zhuwj.auth.entity;

import com.zhuwj.auth.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 关系表用户角色
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUserRole extends BaseEntity {



    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;


}
