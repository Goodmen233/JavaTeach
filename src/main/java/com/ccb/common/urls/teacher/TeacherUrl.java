package com.ccb.common.urls.teacher;

import com.ccb.common.urls.UserUrl;

/**
 * @Description: 教师url
 * @Author: CCB
 * @Date: 2023/2/9 14:17
 */
public class TeacherUrl  extends UserUrl {

    private static final String PREFIX = "/teacher";

    /**
     * 个人中心详情
     */
    public static final String PERSONAL_CENTER = PREFIX + "/personalCenter";

    /**
     * 个人中心修改
     */
    public static final String PERSONAL_CENTER_MODIFY = PERSONAL_CENTER + "/modify";

    /**
     * 课程发布/修改
     */
    public static final String COURSE_PUBLISH = COURSE + "/publish";

    /**
     * 课程删除
     */
    public static final String COURSE_DELETE = COURSE + "/delete";

    /**
     * 课程章节树修改
     */
    public static final String CHAPTER_TREE_MODIFY = CHAPTER_TREE + "/modify";

    /**
     * 课程章节树删除
     */
    public static final String CHAPTER_TREE_DELETE = CHAPTER_TREE + "/delete";

    /**
     * 课程章节内容修改
     */
    public static final String CHAPTER_CONTENT_MODIFY = CHAPTER_CONTENT + "/modify";

    /**
     * 课程章节内容删除
     */
    public static final String CHAPTER_CONTENT_DELETE = CHAPTER_CONTENT + "/delete";

    /**
     * 课程资料修改
     */
    public static final String RESOURCE_MODIFY = RESOURCE + "/modify";

    /**
     * 课程资料删除
     */
    public static final String RESOURCE_DELETE = RESOURCE + "/delete";

    /**
     * 作业/练习发布
     */
    public static final String EXERCISE_PUBLISH = EXERCISE + "/publish";

    /**
     * 课程成绩统计模块
     */
    public static final String SCORE_STATICS = PREFIX + "/scoreStatics";

    /**
     * 话题发布/修改
     */
    public static final String TOPIC_PUBLISH = PREFIX + "/topic/publish";

    /**
     * 话题删除
     */
    public static final String TOPIC_DELETE = PREFIX + "/topic/delete";
}