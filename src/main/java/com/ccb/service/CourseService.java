package com.ccb.service;

import com.ccb.domain.bo.CourseBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.CoursePO;

/**
 * @Description: 课程服务
 * @Author: CCB
 * @Date: 2023/3/27 15:30
 */
public interface CourseService {

    /**
     * 查询课程信息
     *
     * @param courseBO
     * @return
     */
    PageResp<CoursePO> queryCourse(CourseBO courseBO);

    /**
     * 删除课程信息
     *
     * @param id
     */
    void deleteCourseById(Long id);

}
