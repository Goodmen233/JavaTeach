package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.po.StudentScorePO;

import java.util.List;

/**
 * @Description: 学生分数Mapper
 * @Author: CCB
 * @Date: 2023/2/20 17:07
 */
public interface StudentScoreMapper extends BaseMapper<StudentScorePO> {

    /**
     * 查询学生成绩
     *
     * @param studentScorePO
     * @return
     */
    List<StudentScorePO> queryStudentScore(StudentScorePO studentScorePO);
}
