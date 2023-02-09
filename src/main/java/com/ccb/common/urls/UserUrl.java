package com.ccb.common.urls;

/**
 * @Description: 用户账户体系url
 *               学生/老师共用一套url
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

    /**
     * 修改密码
     */
    public static final String UPDATE_PASSWORD = PREFIX + "/updatePassword";

    /**
     * 课程页面信息
     */
    public static final String COURSE = PREFIX + "/course";

    /**
     * 课程章节树信息
     */
    public static final String CHAPTER_TREE = PREFIX + "/chapterTree";

    /**
     * 课程章节内容
     */
    public static final String CHAPTER_CONTENT = PREFIX + "/chapterContent";

    /**
     * 作业/练习模块
     */
    public static final String EXERCISE = PREFIX + "/exercise";

    /**
     * 课程资料详情
     */
    public static final String RESOURCE = PREFIX + "/resource";

    /**
     * 交流模块
     */
    public static final String COMMUNICATION = PREFIX + "/communication";

    /**
     * 发布交流
     */
    public static final String COMMUNICATION_PUBLISH = COMMUNICATION + "/publish";

    /**
     * 删除交流
     */
    public static final String COMMUNICATION_DELETE = COMMUNICATION + "/delete";

    /**
     * 话题模块
     */
    public static final String TOPIC = PREFIX + "/topic";
}
