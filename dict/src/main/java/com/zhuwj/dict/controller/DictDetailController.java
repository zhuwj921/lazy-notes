package com.zhuwj.dict.controller;


import com.zhuwj.common.reponse.ResponseResult;
import com.zhuwj.dict.entity.DictDetail;
import com.zhuwj.dict.service.IDictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  数据字典详情控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-10
 */
@RestController
@RequestMapping("/dict-detail")
public class DictDetailController {

    @Autowired
    private IDictDetailService dictDetailService;

    @GetMapping("list")
    public ResponseResult list(Map map){
        return ResponseResult.ok(dictDetailService.listByMap(map));
    }

    @PostMapping("save")
    public ResponseResult save(@RequestBody DictDetail dictDetail) {
        dictDetailService.save(dictDetail);
        return ResponseResult.ok();
    }

    @PutMapping("save")
    public ResponseResult update(@RequestBody DictDetail dictDetail) {
        dictDetailService.updateById(dictDetail);
        return ResponseResult.ok();
    }

    @DeleteMapping("delete")
    public ResponseResult delete(@RequestParam("id") Integer id) {
        dictDetailService.removeById(id);
        return ResponseResult.ok();
    }

}
