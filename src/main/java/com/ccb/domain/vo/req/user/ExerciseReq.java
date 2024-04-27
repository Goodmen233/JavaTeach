package com.ccb.domain.vo.req.user;

import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 作业/练习列表入参
 * @Author: CCB
 * @Date: 2023/2/9 14:59
 */
@Data
@ApiModel("作业练习列表入参")
public class ExerciseReq extends PageReq {

    @ApiModelProperty("课程id")
    private Long courseId;

}
