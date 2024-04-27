package com.ccb.common.urls.teacher;

/**
 * @Description: 审核模块url
 * @Author: CCB
 * @Date: 2023/2/8 16:57
 */
public class AuditUrl {

    /**
     * 审核列表
     */
    public static final String AUDIT = "/audit";

    /**
     * 审核详情
     */
    public static final String DETAIL = AUDIT + "/detail";

    /**
     * 审核通过
     */
    public static final String PASS = AUDIT + "/pass";

    /**
     * 审核失败(不通过)
     */
    public static final String FAIL = AUDIT + "/fail";
}
