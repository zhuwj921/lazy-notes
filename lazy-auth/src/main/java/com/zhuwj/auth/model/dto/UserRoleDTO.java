package com.zhuwj.auth.model.dto;

import lombok.Data;

import java.util.Set;

/**
 * Description: 用户角色关系对象
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-18
 */

@Data
public class UserRoleDTO {

    private Integer userId;

    private Set<Integer> roleIds;





}
