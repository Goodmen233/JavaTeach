package com.ccb.mapper;

import com.ccb.basemapper.BaseMapper;
import com.ccb.domain.po.ProblemPO;

import java.util.List;

/**
 * @Description: 题目Mapper
 * @Author: CCB
 * @Date: 2023/2/20 18:34
 */
public interface ProblemMapper extends BaseMapper<ProblemPO> {

    /**
     * 查询题目
     *
     * @param problemPO
     * @return
     */
    List<ProblemPO> queryProblem(ProblemPO problemPO);
}
