package com.zhuwj.dict.entity;

import com.zhuwj.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 基础表
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Dict extends BaseEntity {


    /**
     * 数据字典名称
     */
    private String name;

    /**
     * 数据字典唯一标识
     */
    private String code;

    /**
     * 备注信息
     */
    private String remark;


}
