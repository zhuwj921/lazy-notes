package com.zhuwj.dict.rest;


import com.zhuwj.common.response.ResponseResult;
import com.zhuwj.dict.service.DictCacheService;
import com.zhuwj.dict.util.DictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典缓存控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-10
 */
@RestController
@RequestMapping("/dict/cache")
public class DictCacheController {

    @Autowired
    private DictCacheService dictCacheService;

    /**
     * 更新缓存数据字典
     *
     * @return
     */
    @GetMapping
    public ResponseResult dictCache() {
        dictCacheService.clearDictCache();
        dictCacheService.dictCache();
        return ResponseResult.ok();
    }

    /**
     * 数据字典详情集合查询
     *
     * @param dictId
     * @return
     */
    @GetMapping("list/{dictId}")
    public ResponseResult list(@PathVariable("dictId") Long dictId) {
        return ResponseResult.ok(DictUtil.mapDictDetailByDictId(dictId));
    }

    /**
     * 数据字典详情map返回
     *
     * @param dictId
     * @return
     */
    @GetMapping("map/{dictId}")
    public ResponseResult map(@PathVariable("dictId") Long dictId) {
        return ResponseResult.ok(DictUtil.mapDictDetailByDictId(dictId));
    }

}
