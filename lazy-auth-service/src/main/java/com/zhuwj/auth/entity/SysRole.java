package com.zhuwj.auth.entity;

import com.zhuwj.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends BaseEntity {


    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 角色code
     */
    private String code;


}
