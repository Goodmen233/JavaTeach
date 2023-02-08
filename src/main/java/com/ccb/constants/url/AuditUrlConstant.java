package com.ccb.constants.url;

/**
 * @Description: 审核模块url
 * @Author: CCB
 * @Date: 2023/2/8 16:57
 */
public class AuditUrlConstant {

    /**
     * 前缀
     */
    private static final String PREFIX = "/audit";

    /**
     * 审核详情
     */
    public static final String DETAIL = PREFIX + "/detail";

    /**
     * 审核通过
     */
    public static final String PASS = PREFIX + "/pass";

    /**
     * 审核失败(不通过)
     */
    public static final String FAIL = PREFIX + "/fail";
}
