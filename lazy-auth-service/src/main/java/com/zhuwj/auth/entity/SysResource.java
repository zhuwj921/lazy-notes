package com.zhuwj.auth.entity;

import com.zhuwj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysResource extends BaseEntity {


    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String code;

    /**
     * 菜单图片
     */
    private String icon;

    /**
     * 父级id
     */
    private Long pId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型：1 菜单 2 按钮 3 资源
     */
    private Integer type;


}
