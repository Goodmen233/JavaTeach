package com.ccb.mapper;

import com.ccb.domain.bo.CourseBO;
import com.ccb.domain.po.CoursePO;

import java.util.List;

/**
 * @Description: 课程Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:54
 */
public interface CourseMapper extends BaseMapper<CoursePO> {

    /**
     * 查询课程信息
     *
     * @param courseBO
     * @return
     */
    List<CoursePO> queryCourse(CourseBO courseBO);

    /**
     * 统计课程总数
     *
     * @param courseBO
     * @return
     */
    Long countCourse(CourseBO courseBO);
}
