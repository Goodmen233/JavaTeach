package com.ccb.service.impl;

import com.ccb.common.utils.PageUtil;
import com.ccb.domain.bo.CourseBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.CoursePO;
import com.ccb.mapper.CourseMapper;
import com.ccb.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description: 课程服务实现
 * @Author: CCB
 * @Date: 2023/3/27 15:37
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    @Override
    public PageResp<CoursePO> queryCourse(CourseBO courseBO) {
        PageUtil.checkPage(courseBO);
        PageResp<CoursePO> page = new PageResp<>();
        page.setRows(courseMapper.queryCourse(courseBO));
        page.setTotal(courseMapper.countCourse(courseBO));
        return page;
    }

    @Override
    public void deleteCourseById(Long id) {
        courseMapper.deleteByPrimaryKey(id);
    }
}
