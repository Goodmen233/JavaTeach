package com.ccb.common.urls;

/**
 * @Description: 学生/老师共用一套url
 * @Author: CCB
 * @Date: 2023/2/10 11:22
 */
public class CommonUrl {

    /**
     * 前缀
     */
    private static final String PREFIX = "/common";

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
     * 讨论模块
     */
    public static final String FORUM = PREFIX + "/forum";

    /**
     * 评论列表
     */
    public static final String COMMENT = PREFIX + "/comment";

    /**
     * 评论发布
     */
    public static final String COMMENT_PUBLISH = COMMENT + "/publish";

    /**
     * 评论删除
     */
    public static final String COMMENT_DELETE = COMMENT + "/delete";

    /**
     * 发布讨论
     */
    public static final String FORUM_PUBLISH = FORUM + "/publish";

    /**
     * 删除讨论
     */
    public static final String FORUM_DELETE = FORUM + "/delete";

    /**
     * 话题模块
     */
    public static final String TOPIC = PREFIX + "/topic";
}
