package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.po.TeacherPO;

import java.util.List;

/**
 * @Description: 教师Mapper
 * @Author: CCB
 * @Date: 2023/2/20 18:35
 */
public interface TeacherMapper extends BaseMapper<TeacherPO> {

    /**
     * 查询教师信息
     *
     * @param teacherPO
     * @return
     */
    List<TeacherPO> queryTeacher(TeacherPO teacherPO);
}
