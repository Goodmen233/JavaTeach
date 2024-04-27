package com.ccb.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 练习/作业解答详情
 * @Author: CCB
 * @Date: 2023/2/14 22:20
 */
@Data
@ApiModel("练习/作业解答详情")
public class ExerciseDetailBO {

    @ApiModelProperty("题目id")
    private Long problemId;

    @ApiModelProperty("题目内容")
    private String problemContent;

    @ApiModelProperty("学生答题结果")
    private String studentAnswer;

    @ApiModelProperty("正确答案")
    private String rightAnswer;
}
