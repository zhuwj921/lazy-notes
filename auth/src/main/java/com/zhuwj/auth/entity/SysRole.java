package com.zhuwj.auth.entity;

import com.zhuwj.auth.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends BaseEntity {


    private String roleDesc;

    private String roleName;

    private String roleCode;


}
