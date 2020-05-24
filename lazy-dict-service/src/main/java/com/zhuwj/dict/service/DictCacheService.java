package com.zhuwj.dict.service;

import com.zhuwj.dict.entity.DictDetail;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典缓存服务
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-13
 */
public interface DictCacheService {

    /**
     * 数据字典缓存
     */
    Map<Long, List<DictDetail>> dictCache();

    /**
     * 清空数据字典缓存
     */
    void clearDictCache();

}
