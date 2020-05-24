package com.zhuwj.attachment.service.impl;

import com.zhuwj.attachment.entity.Attachment;
import com.zhuwj.attachment.mapper.AttachmentMapper;
import com.zhuwj.attachment.service.AttachmentService;
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
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {

}
