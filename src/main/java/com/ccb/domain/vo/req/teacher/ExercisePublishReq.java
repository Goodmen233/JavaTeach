package com.ccb.domain.vo.req.teacher;

import com.ccb.domain.bo.ProblemBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 作业/练习发布入参
 * @Author: CCB
 * @Date: 2023/2/10 10:41
 */
@Data
@ApiModel("作业练习发布入参")
public class ExercisePublishReq {

    @ApiModelProperty("练习/作业入参")
    private Long exerciseId;

    @ApiModelProperty("题目详情集合")
    private List<ProblemBO> problemList;

}
