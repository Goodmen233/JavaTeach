package com.ccb.controller;

import com.ccb.common.utils.OssUtil;
import com.ccb.domain.vo.req.file.CkUploadReq;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: OSS控制层
 * @Author: CCB
 * @Date: 2023/4/11 13:26
 */
@RestController
@RequestMapping("/oss")
@RequiredArgsConstructor
@Api(tags = "OSS相关接口")
public class OssController {

    @ApiOperation("上传单个文件")
    @PostMapping("uploadOneFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        //返回上传oss的url
        return OssUtil.uploadOneFile(file);
    }

    @ApiOperation("上传多个文件")
    @PostMapping("uploadArrayFile")
    @ResponseBody
    public List<String> uploadArrayFile(MultipartFile[] files) {
        //返回上传oss的url
        return OssUtil.uploadArrayFile(files);
    }

    @ApiOperation("删除文件")
    @PostMapping("deleteFile")
    @ResponseBody
    public boolean deleteFile(@RequestBody String fileUrl) {
        //返回是否删除成功
        return OssUtil.deleteFile(fileUrl);
    }

    @ApiOperation("文件图片上传-new")
    @PostMapping("imgUpload")
    @ResponseBody
    public Map<String, Object> imageUpload(CkUploadReq ckUploadReq) {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("uploaded", 1);
        map.put("url", OssUtil.uploadOneFile(ckUploadReq.getUpload()));
        map.put("fileName", UUID.randomUUID());
        return map;
    }

}

