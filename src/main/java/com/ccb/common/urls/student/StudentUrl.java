package com.ccb.common.urls.student;

import com.ccb.common.urls.CommonUrl;

/**
 * @Description: 学生端url
 * @Author: CCB
 * @Date: 2023/2/9 14:15
 */
public class StudentUrl extends CommonUrl {

    private static final String PREFIX = "/student";

    /**
     * 个人中心详情
     */
    public static final String PERSONAL_CENTER = PREFIX + "/personalCenter";

    /**
     * 个人中心修改
     */
    public static final String PERSONAL_CENTER_MODIFY = PERSONAL_CENTER + "/modify";

    /**
     * 作业/练习模块提交/修改
     */
    public static final String EXERCISE_SUBMIT = EXERCISE + "/submit";

    /**
     * 成绩详情模块
     */
    public static final String EXERCISE_DETAIL = EXERCISE + "/detail";
}
