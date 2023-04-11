package com.ccb.controller;

import com.ccb.common.utils.OssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: OSS控制层
 * @Author: CCB
 * @Date: 2023/4/11 13:26
 */
@RestController
@RequestMapping("/oss")
public class OssController {

    @PostMapping("uploadOneFile")
    public String uploadFile(MultipartFile file) {
        //返回上传oss的url
        return OssUtil.uploadOneFile(file);
    }

    @PostMapping("uploadArrayFile")
    public List<String> uploadArrayFile(MultipartFile[] files) {
        //返回上传oss的url
        return OssUtil.uploadArrayFile(files);
    }

    @PostMapping("deleteFile")
    public boolean deleteFile(@RequestBody String fileUrl) {
        //返回是否删除成功
        return OssUtil.deleteFile(fileUrl);
    }

}

