package com.ccb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.ccb.common.urls.FileUrl;
import com.ccb.common.utils.ImageUtil;
import com.ccb.common.utils.OssUtil;
import com.ccb.domain.common.ResultInfo;
import com.ccb.domain.po.FilePO;
import com.ccb.domain.vo.req.file.CkUploadReq;
import com.ccb.domain.vo.req.file.DeleteReq;
import com.ccb.domain.vo.req.file.UploadReq;
import com.ccb.service.FileService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: 文件相关接口
 * @Author: CCB
 * @Date: 2023/2/10 10:28
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@Api(tags = "文件相关接口")
public class FileController {

    private final FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping(FileUrl.UPLOAD)
    @ResponseBody
    public ResultInfo<FilePO> upload(UploadReq uploadReq) {
        FilePO filePO = new FilePO();
        BeanUtil.copyProperties(uploadReq, filePO);
        return ResultInfo.success(fileService.saveFile(filePO));
    }

    @ApiOperation("文件删除")
    @PostMapping(FileUrl.DELETE)
    @ResponseBody
    public ResultInfo<Boolean> delete(DeleteReq deleteReq) {
        fileService.deleteFileById(deleteReq.getId());
        return ResultInfo.success(Boolean.TRUE);
    }

    @ApiOperation("文件图片上传-new")
    @PostMapping(FileUrl.IMG_UPLOAD)
    @ResponseBody
    public Map<String, Object> imageUpload(CkUploadReq ckUploadReq) {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("uploaded", 1);
        map.put("url", OssUtil.uploadOneFile(ImageUtil.base64ToMultipartFile(ckUploadReq.getUpload())));
        map.put("fileName", UUID.randomUUID());
        return map;
    }

}
