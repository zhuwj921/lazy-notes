package com.zhuwj.quartz.job.util;

import com.zhuwj.quartz.job.base.BaseJob;

/**
 * Description: TODO
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-26
 */

public final class JobUtil {

    /**
     * 根据全类名获取实例
     * @param classname
     * @return
     * @throws Exception
     */
    public static BaseJob getClass(String classname) throws Exception {
        Class<?> clazz = Class.forName(classname);
        return (BaseJob) clazz.getDeclaredConstructor().newInstance();
    }
}
