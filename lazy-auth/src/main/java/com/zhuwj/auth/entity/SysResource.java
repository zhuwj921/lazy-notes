package com.zhuwj.auth.entity;

import com.zhuwj.auth.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysResource extends BaseEntity {


    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源权限标识
     */
    private String permission;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 模块名称
     */
    private String modeuleName;


}
