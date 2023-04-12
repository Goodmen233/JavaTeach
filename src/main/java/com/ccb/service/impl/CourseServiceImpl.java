package com.ccb.service.impl;

import com.ccb.common.enums.ScoreLinkTypeEnum;
import com.ccb.common.utils.PageUtil;
import com.ccb.domain.bo.CourseBO;
import com.ccb.domain.common.PageResp;
import com.ccb.domain.po.CoursePO;
import com.ccb.domain.po.StudentScorePO;
import com.ccb.domain.vo.resp.teacher.ScoreStaticsResp;
import com.ccb.mapper.CourseMapper;
import com.ccb.mapper.StudentScoreMapper;
import com.ccb.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: 课程服务实现
 * @Author: CCB
 * @Date: 2023/3/27 15:37
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    private final StudentScoreMapper studentScoreMapper;

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

    @Override
    public ScoreStaticsResp courseStatics(Long id) {
        ScoreStaticsResp scoreStaticsResp = new ScoreStaticsResp();
        Example example = new Example(StudentScorePO.class);
        example.clear();
        example.createCriteria()
                .andEqualTo("link_type", ScoreLinkTypeEnum.SOURCE.getIndex())
                .andEqualTo("link_id", id);
        List<StudentScorePO> studentScorePOS = studentScoreMapper.selectByExample(example);
        scoreStaticsResp.setStudentScoreList(studentScorePOS);
        return scoreStaticsResp;
    }

    @Override
    public List<Long> queryCourseIdListByClassId(Long classId) {
        return courseMapper.queryCourseIdListByClassId(classId);
    }
}
