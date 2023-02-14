package com.ccb.domain.vo.req.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 作业/练习解答详情入参
 * @Author: CCB
 * @Date: 2023/2/9 17:58
 */
@Data
@ApiModel("作业练习解答详情入参")
public class ExerciseDetailReq {

    @ApiModelProperty("作业/练习id")
    private Long id;
}
