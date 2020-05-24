package com.zhuwj.common.security.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhuwj.common.base.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO extends BaseDTO {

    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 电话
     */
    private String phone;
    /**
     * 最新登入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime latestTime;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    /**
     * 是否禁用
     */
    private Boolean enabled;

}
