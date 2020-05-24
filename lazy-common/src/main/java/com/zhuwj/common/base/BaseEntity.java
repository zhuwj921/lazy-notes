package com.zhuwj.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhuwj.common.util.WebContextUtil;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 实体类基础信息
 * @author: zhuwj
 * @create: 2020-05-16 23:39
 **/
@Data
public class BaseEntity<T> extends Model<BaseEntity<T>> {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime gmtCreate;
    /**
     * 创建者id
     */
    private Long createId;
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
     * 删除标志 @TableLogic 逻辑删除
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;

    /**
     * 版本号 默认0
     */
    private Integer version;


    /**
     * 初始化默认数据
     */
    public void init() {
        this.setCreateId(WebContextUtil.getUser().getId());
        this.setGmtCreate(LocalDateTime.now());
    }

    /**
     * 设置更新的默认数据
     *
     * @param t
     * @param <T>
     */
    public <T extends BaseEntity> void modify(T t) {
        LocalDateTime dateTime = LocalDateTime.now();
        this.setId(t.getId());
        this.setGmtModified(dateTime);
        this.setModifiedId(WebContextUtil.getUser().getId());
        this.setVersion(t.getVersion() + 1);
    }


}
