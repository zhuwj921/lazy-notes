package com.zhuwj.dict.service.impl;

import com.zhuwj.dict.entity.DictDetail;
import com.zhuwj.dict.mapper.DictDetailMapper;
import com.zhuwj.dict.service.IDictCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CacheConfig(cacheNames = "dict")
@Service
public class DictCacheServiceImpl implements IDictCacheService {

    @Autowired
    private DictDetailMapper dictDetailMapper;

    @Cacheable("dict")
    @Override
    public Map<Integer, List<DictDetail>> dictCache() {
        List<DictDetail> list = dictDetailMapper.selectByMap(new HashMap<>());
        Map<Integer, List<DictDetail>> map = list.stream().collect(Collectors.groupingBy(DictDetail::getDictId));
        return map;
    }

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    public void clearDictCache() {
    }
}
