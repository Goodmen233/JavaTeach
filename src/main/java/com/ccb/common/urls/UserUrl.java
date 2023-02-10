package com.ccb.common.urls;

/**
 * @Description: 用户账户体系url
 * @Author: CCB
 * @Date: 2023/2/8 16:22
 */
public class UserUrl {

    /**
     * 前缀
     */
    private static final String PREFIX = "/user";

    /**
     * 登录
     */
    public static final String LOGIN = PREFIX + "/login";

    /**
     * 注册
     */
    public static final String REGISTER = PREFIX + "/register";

    /**
     * 注册信息提交
     */
    public static final String REGISTER_SUBMIT = REGISTER + "/submit";

}
