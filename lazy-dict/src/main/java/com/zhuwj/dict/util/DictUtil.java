package com.zhuwj.dict.util;

import com.zhuwj.dict.entity.DictDetail;
import com.zhuwj.dict.service.IDictCacheService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据字典工具类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-10
 */
@Component
public class DictUtil {

    private static IDictCacheService dictCacheService;

    @Autowired
    private IDictCacheService dictCacheServiceBean;

    @PostConstruct
    public void init() {
        this.dictCacheService = dictCacheServiceBean;
    }

    /**
     * 根据数据字典ID 查询对应的数据字典详情
     *
     * @param dictId
     * @return list
     */
    public static List<DictDetail> listDictDetailByDictId(Integer dictId) {
        Map<Integer, List<DictDetail>> map = dictCacheService.dictCache();
        List<DictDetail> list = map.get(dictId);
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().sorted(Comparator.comparing(DictDetail::getSort)).collect(Collectors.toList());
    }

    /**
     * 根据数据字典ID 查询对应的数据字典详情
     *
     * @param dictId
     * @return map
     */
    public static Map<String, DictDetail> mapDictDetailByDictId(Integer dictId) {
        List<DictDetail> list = listDictDetailByDictId((dictId));
        if (CollectionUtils.isEmpty(list)) {
            return new HashMap<>();
        }
        Map<String, DictDetail> map = list.stream().collect(Collectors.toMap(DictDetail::getKey, dictDetail -> dictDetail, (k1, k2) -> k1));
        return map;
    }

    /**
     * 根据数据字典id 数据详情key 获取对应数据详情对象
     *
     * @param dictId
     * @param dictDetailKey
     * @return
     */
    public static DictDetail getDictDetail(Integer dictId, String dictDetailKey) {
        Map<String, DictDetail> map = mapDictDetailByDictId(dictId);
        DictDetail dictDetail = map.getOrDefault(dictDetailKey, new DictDetail());
        return dictDetail;
    }

    /**
     * 根据数据字典id 数据详情key 获取对应数据详情对象的label
     *
     * @param dictId
     * @param dictDetailKey
     * @return
     */
    public static String getLabelByKey(Integer dictId, String dictDetailKey) {
        return getDictDetail(dictId, dictDetailKey).getLabel();
    }

    /**
     * 根据数据字典id 数据详情key 获取对应数据详情对象的value
     *
     * @param dictId
     * @param dictDetailKey
     * @return
     */
    public static String getValueByKey(Integer dictId, String dictDetailKey) {
        return getDictDetail(dictId, dictDetailKey).getLabel();
    }


}
