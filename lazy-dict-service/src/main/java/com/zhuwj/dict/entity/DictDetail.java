package com.zhuwj.dict.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zhuwj.common.base.BaseEntity;
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
public class DictDetail extends BaseEntity {

    /**
     * 数据字典id
     */
    private Long dictId;

    /**
     * 数据字典详情唯一编号
     */
    @TableField("`key`")
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 标签名称
     */
    private String label;

    /**
     * 排序
     */
    private Integer sort;


}
