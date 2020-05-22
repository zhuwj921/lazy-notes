package com.zhuwj.auth.base;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhuwj.auth.util.WebContextUtil;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 基础实体类信息
 * @author: zhuwj
 * @create: 2020-05-16 23:39
 **/
@Data
public class BaseEntity<T> extends Model<BaseEntity<T>> {


    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 通用唯一识别码
     */
    private String uuid;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 创建者id
     */
    private Integer createId;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
    /**
     * 更新者id
     */
    private Integer updateId;
    /**
     * 删除标志 @TableLogic 逻辑删除
     */
    @TableLogic
    private Boolean deleted;

    /**
     * 版本号 默认0
     */
    private Integer version;


    /**
     * 初始化默认数据
     */
    public void init() {
        this.setUuid(IdUtil.randomUUID());
        this.setCreateId(WebContextUtil.getUser().getId());
        this.setUpdateId(WebContextUtil.getUser().getId());
        this.setCreateTime(LocalDateTime.now());
        this.setUpdateTime(LocalDateTime.now());
    }

    /**
     * 初始化更新的默认数据
     *
     * @param t
     * @param <T>
     */
    public <T extends BaseEntity> void modify(T t) {
        LocalDateTime dateTime = LocalDateTime.now();
        this.setId(t.getId());
        this.setUpdateTime(dateTime);
        this.setUpdateId(WebContextUtil.getUser().getId());
        this.setVersion(t.getVersion() + 1);
    }

}
