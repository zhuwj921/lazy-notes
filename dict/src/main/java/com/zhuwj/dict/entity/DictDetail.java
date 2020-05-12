package com.zhuwj.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 删除标志
     */
    private Boolean deleted;

    /**
     * 数据字典id
     */
    private Integer dictId;

    /**
     * 唯一key
     */
    @TableField("`key`")
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 标签的值
     */
    private String label;

    /**
     * 排序
     */
    private Integer sort;


}
