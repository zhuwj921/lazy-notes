package com.zhuwj.auth.base;

import com.zhuwj.auth.util.WebContextUtil;

/**
 * @description: 基础控制器信息
 * @author: zhuwj
 * @create: 2020-05-17 00:01
 **/

public class BaseController {

    /**
     * 获取当前用户id
     *
     * @return
     */
    public Integer getCurrentUserId() {
        return WebContextUtil.getUser().getId();
    }


}
