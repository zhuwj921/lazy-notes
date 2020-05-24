package com.zhuwj.dict.service.impl;

import com.zhuwj.dict.entity.DictDetail;
import com.zhuwj.dict.mapper.DictDetailMapper;
import com.zhuwj.dict.service.DictCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "dict")
@Service
public class DictCacheServiceImpl implements DictCacheService {

    private final DictDetailMapper dictDetailMapper;

    @Cacheable("dict")
    @Override
    public Map<Long, List<DictDetail>> dictCache() {
        List<DictDetail> list = dictDetailMapper.selectByMap(new HashMap<>());
        Map<Long, List<DictDetail>> map = list.stream().collect(Collectors.groupingBy(DictDetail::getDictId));
        return map;
    }

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    public void clearDictCache() {
    }
}
