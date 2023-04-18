package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.bo.StudentProblemBO;
import com.ccb.domain.po.StudentProblemPO;

import java.util.List;

/**
 * @Description: 学生解答Mapper
 * @Author: CCB
 * @Date: 2023/2/20 17:06
 */
public interface StudentProblemMapper extends BaseMapper<StudentProblemPO> {

    /**
     * 查询学生题目解答
     *
     * @param studentProblemBO
     * @return
     */
    List<StudentProblemPO> queryStudentProblem(StudentProblemBO studentProblemBO);

}
