package com.zhuwj.dict.controller;


import com.zhuwj.common.response.ResponseResult;
import com.zhuwj.dict.entity.Dict;
import com.zhuwj.dict.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-10
 */
@RestController
@RequestMapping("/dict")
public class DictController {


    @Autowired
    private IDictService dictService;

    @GetMapping("list")
    public ResponseResult list(Map map){
        return ResponseResult.ok(dictService.listByMap(map));
    }

    @PostMapping("save")
    public ResponseResult save(@RequestBody Dict dict) {
        dictService.save(dict);
        return ResponseResult.ok();
    }

    @PutMapping("save")
    public ResponseResult update(@RequestBody Dict dict) {
        dictService.updateById(dict);
        return ResponseResult.ok();
    }

    @DeleteMapping("delete")
    public ResponseResult delete(@RequestParam("id") Integer id) {
        dictService.removeById(id);
        return ResponseResult.ok();
    }


}
