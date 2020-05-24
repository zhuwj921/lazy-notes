package com.zhuwj.attachment.entity;

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
public class Attachment extends BaseEntity {


    /**
     * 附件名称
     */
    private String name;
    /**
     * 原附件名称
     */
    private String originalName;

    /**
     * 附件路径
     */
    private String path;

    /**
     * 文件大小KB
     */
    private Long size;

    /**
     * 模块标识
     */
    private String moduleCode;

    /**
     * 来源标识
     */
    private String sourceCode;

    /**
     * 访问url
     */
    private String url;


}
