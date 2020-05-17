package com.zhuwj.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhuwj.auth.entity.SysUser;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String nickName;

    private String avatarPath;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Boolean enabled;


    public void init(SysUser sysUser){
        BeanUtils.copyProperties(sysUser, this);
    }

}
