package com.ccb.domain.vo.resp.student;

import com.ccb.domain.bo.ExerciseDetailBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 作业/练习解答详情出参
 * @Author: CCB
 * @Date: 2023/2/9 17:59
 */
@Data
@ApiModel("作业/练习解答详情出参")
public class ExerciseDetailResp {

    @ApiModelProperty("作业/练习id")
    private Long exerciseId;

    @ApiModelProperty("题目作答结果集合")
    private List<ExerciseDetailBO> exerciseDetailBOList;

}
