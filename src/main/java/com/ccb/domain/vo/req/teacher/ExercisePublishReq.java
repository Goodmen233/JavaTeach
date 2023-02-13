package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description: 作业/练习发布入参
 * @Author: CCB
 * @Date: 2023/2/10 10:41
 */
@Data
@ApiModel("作业/练习发布入参")
public class ExercisePublishReq {
    /*
    exerciseId
    List<ProblemPO>
            |
           List<ChoicePO>
     */
}
