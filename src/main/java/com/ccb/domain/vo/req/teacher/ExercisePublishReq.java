package com.ccb.domain.vo.req.teacher;

import com.ccb.common.enums.BooleanEnum;
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

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("结束后是否查看答案: " + BooleanEnum.KEY_VALUE)
    private Integer showAnswer;

    @ApiModelProperty("关联课程id")
    private Long courseId;

    @ApiModelProperty("题目详情集合")
    private List<ProblemBO> problemList;

}
