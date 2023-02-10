package com.ccb.common.urls;

/**
 * @Description: 文件相关url
 * @Author: CCB
 * @Date: 2023/2/8 17:50
 */
public class FileUrl {

    /**
     * 前缀
     */
    private final static String PREFIX = "/file";

    /**
     * 文件列表
     */
    public final static String VIEW = PREFIX + "/view";

    /**
     * 添加文件
     */
    public static final String UPLOAD = PREFIX + "/upload";

    /**
     * 删除文件
     */
    public static final String DELETE = PREFIX + "/delete";
}
