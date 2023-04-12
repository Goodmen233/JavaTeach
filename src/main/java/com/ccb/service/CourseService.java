package com.ccb.service;

import com.ccb.domain.bo.CourseBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.CoursePO;
import com.ccb.domain.vo.resp.teacher.ScoreStaticsResp;

import java.util.List;

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

    /**
     * 课程统计
     *
     * @param id
     * @return
     */
    ScoreStaticsResp courseStatics(Long id);

    /**
     * 通过班级id查询课程id
     *
     * @param classId
     * @return
     */
    List<Long> queryCourseIdListByClassId(Long classId);

}
