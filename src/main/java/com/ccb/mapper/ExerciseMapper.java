package com.ccb.mapper;

import com.ccb.domain.bo.ExerciseQueryBO;
import com.ccb.domain.po.ExercisePO;

import java.util.List;

/**
 * @Description: 练习/作业Mapper
 * @Author: CCB
 * @Date: 2023/2/20 16:55
 */
public interface ExerciseMapper extends BaseMapper<ExercisePO> {

    /**
     * 查询作业/练习
     *
     * @param exerciseQueryBO
     * @return
     */
    List<ExercisePO> queryExercise(ExerciseQueryBO exerciseQueryBO);

    /**
     * 统计作业/练习
     *
     * @param exerciseQueryBO
     * @return
     */
    Long countExercise(ExerciseQueryBO exerciseQueryBO);
}
