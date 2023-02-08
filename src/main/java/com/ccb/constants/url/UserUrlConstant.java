package com.ccb.constants.url;

/**
 * @Description: 用户账户体系url
 *               学生/老师共用一套url
 * @Author: CCB
 * @Date: 2023/2/8 16:22
 */
public class UserUrlConstant {

    /**
     * 前缀
     */
    private static final String PREFIX = "/user";

    /**
     * 登录
     */
    public static final String LOGIN = PREFIX + "/login";

    /**
     * 注册详情
     */
    public static final String REGISTER_DETAIL = PREFIX + "/registerDetail";

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
    public static final String PERSONAL_CENTER = PREFIX + "/personalCenter";

    /**
     * 个人中心修改
     */
    public static final String PERSONAL_CENTER_MODIFY = PERSONAL_CENTER + "/modify";

    /**
     * 课程页面信息
     */
    public static final String COURSE = PREFIX + "/course";

    /**
     * 课程章节树信息
     */
    public static final String CHAPTER_TREE = PREFIX + "/chapterTree";

    /**
     * 课程章节内容详情
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
