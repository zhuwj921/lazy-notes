package com.zhuwj.attachment.rest;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuwj.attachment.entity.Attachment;
import com.zhuwj.attachment.service.AttachmentService;
import com.zhuwj.common.base.BaseController;
import com.zhuwj.common.enums.ErrorCodeEnum;
import com.zhuwj.common.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 * 基础表 前端控制器
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/attachment")
@RequiredArgsConstructor
@Slf4j
public class AttachmentController extends BaseController {

    @Value("${spring.servlet.multipart.location}")
    private String fileTempPath;

    private final AttachmentService attachmentService;

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param map
     */
    @GetMapping("/page")
    public ResponseResult page(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize, Map map) {
        Page page = new Page(pageNum, pageSize);
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        IPage result = attachmentService.page(page, wrapper);
        return ResponseResult.ok(result);
    }

    /**
     * 根据ID查找数据
     *
     * @param id
     */
    @GetMapping("{id}")
    public ResponseResult find(@PathVariable("id") Long id) {
        Attachment result = attachmentService.getById(id);
        return ResponseResult.ok(result);
    }

    /**
     * 保存数据
     *
     * @param attachment
     */
    @PostMapping
    public ResponseResult save(@RequestBody Attachment attachment) {
        attachment.init();
        attachmentService.save(attachment);
        return ResponseResult.ok();
    }

    /**
     * 修改数据
     *
     * @param attachment
     */
    @PutMapping
    public ResponseResult update(@RequestBody Attachment attachment) {

        Attachment result = attachmentService.getById(attachment.getId());
        if (result == null) {
            return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        attachment.modify(result);
        attachmentService.updateById(attachment);
        return ResponseResult.ok();
    }

    /**
     * 根据id删除数据
     *
     * @param id
     */
    @DeleteMapping("{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        Attachment result = attachmentService.getById(id);
        if (result == null) {
            return ResponseResult.error(ErrorCodeEnum.DATA_NOT_EXIST);
        }
        attachmentService.removeById(id);
        return ResponseResult.ok();
    }

    @GetMapping(value = "/local", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult local(@RequestParam("file") MultipartFile file,
                                @RequestParam("moduleCode") String moduleCode,
                                @RequestParam("sourceCode") String sourceCode) {

        String fileName = file.getOriginalFilename();
        Long size = file.getSize();
        String fileType = StrUtil.subAfter(fileName, ".", true);
        String newFileName = IdUtil.simpleUUID().concat(".").concat(fileType);
        String date = DateUtil.format(LocalDateTime.now(), "yyyyMMdd");
        String localFilePath = fileTempPath.concat(File.separator).concat(date).concat(File.separator);
        try {
            FileUtil.mkdir(localFilePath);
            file.transferTo(new File(localFilePath.concat(newFileName)));
        } catch (IOException e) {
            log.error("【文件上传至本地】失败，绝对路径：{}", localFilePath, e);
            return ResponseResult.error(ErrorCodeEnum.USER_UPLOAD_FILE_IS_ABNORMAL);
        }
        log.info("【文件上传至本地】绝对路径：{}", localFilePath);
        Attachment attachment = new Attachment();
        attachment.setName(newFileName);
        attachment.setOriginalName(fileName);
        attachment.setSize(size);
        attachment.setPath(localFilePath);
        attachment.setModuleCode(moduleCode);
        attachment.setSourceCode(sourceCode);
        save(attachment);
        return ResponseResult.ok(attachment);
    }

}
