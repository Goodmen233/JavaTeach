package com.ccb.constants.url;

/**
 * @Description: 用户账户体系url
 * @Author: CCB
 * @Date: 2023/2/8 16:22
 */
public class UserUrlConstant {

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
     * 修改密码
     */
    public static final String UPDATE_PASSWORD = PREFIX + "/updatePassword";

    /**
     * 个人中心详情
     */
    private static final String PERSONAL_CENTER = PREFIX + "/personalCenter";

    /**
     * 个人中心修改
     */
    public static final String PERSONAL_CENTER_MODIFY = PERSONAL_CENTER + "/modify";

}
