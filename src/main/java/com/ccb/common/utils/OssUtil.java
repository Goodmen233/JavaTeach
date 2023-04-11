package com.ccb.common.utils;

import com.ccb.context.SpringContextHolder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description: OSS静态工具类
 * @Author: CCB
 * @Date: 2023/4/11 13:23
 */
public class OssUtil {

    static OssUtils ossUtils = SpringContextHolder.getBean(OssUtils.class);

    public static String uploadOneFile(MultipartFile file) {
        return ossUtils.uploadOneFile(file);
    }

    public static List<String> uploadArrayFile(MultipartFile[] files) {
        return ossUtils.uploadArrayFile(files);
    }

    public static boolean deleteFile(String fileUrl) {
        return ossUtils.deleteFile(fileUrl);
    }

}
