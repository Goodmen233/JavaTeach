package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.po.StudentPO;

import java.util.List;

/**
 * @Description: 学生Mapper
 * @Author: CCB
 * @Date: 2023/2/22 18:50
 */
public interface StudentMapper extends BaseMapper<StudentPO> {

    /**
     * 查询学生信息
     *
     * @param studentPO
     * @return
     */
    List<StudentPO> queryStudent(StudentPO studentPO);
}
