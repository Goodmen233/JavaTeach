package com.ccb.service;

import com.ccb.domain.bo.ExerciseBO;
import com.ccb.domain.bo.ExerciseQueryBO;
import com.ccb.domain.common.PageResp;

/**
 * @Description: 练习/作业服务
 * @Author: CCB
 * @Date: 2023/3/27 18:34
 */
public interface ExerciseService {

    /**
     * 查询作业/练习信息
     *
     * @param exerciseQueryBO
     * @return
     */
    PageResp<ExerciseBO> queryExercise(ExerciseQueryBO exerciseQueryBO);
}
