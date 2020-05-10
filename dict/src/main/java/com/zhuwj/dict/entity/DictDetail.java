package com.zhuwj.dict.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;


}
