package com.zhuwj.dict.service.impl;

import com.zhuwj.dict.entity.Dict;
import com.zhuwj.dict.mapper.DictMapper;
import com.zhuwj.dict.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基础表 服务实现类
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}
