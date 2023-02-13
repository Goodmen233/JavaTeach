package com.ccb.domain.vo.resp.student;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description: 作业/练习解答详情出参
 * @Author: CCB
 * @Date: 2023/2/9 17:59
 */
@Data
@ApiModel("作业/练习解答详情出参")
public class ExerciseDetailResp {
    /*
    exerciseId
    List<BO>
        |
        problemId
        problemContent
        studentAnswer
        rightAnswer
     */
}
