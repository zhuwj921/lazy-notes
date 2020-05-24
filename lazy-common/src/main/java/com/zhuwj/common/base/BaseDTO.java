package com.zhuwj.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: DTO类基础信息
 * @author: zhuwj
 * @create: 2020-05-24 07:50
 **/
@Data
public class BaseDTO implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime gmtCreate;
    /**
     * 创建者id
     */
    private Integer createId;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime gmtModified;
    /**
     * 更新者id
     */
    private Long modifiedId;
    /**
     * 删除标志
     */
    private Boolean deleted;

    /**
     * 版本号 默认0
     */
    private Integer version;

}
