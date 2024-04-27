package com.ccb.service;

import com.ccb.domain.vo.req.student.ExerciseSubmitReq;
import com.ccb.domain.vo.resp.student.ExerciseDetailResp;

/**
 * @Description: 学生问题服务
 * @Author: CCB
 * @Date: 2023/4/6 13:58
 */
public interface StudentProblemService {

    /**
     * 作业/练习模块提交
     *
     * @param exerciseSubmitReq
     */
    void exerciseSubmit(ExerciseSubmitReq exerciseSubmitReq);

    /**
     * 查询作业/练习解答详情
     *
     * @param id
     * @return
     */
    ExerciseDetailResp queryExerciseDetail(Long id);
}
