package com.ccb.domain.bo;

import com.ccb.common.enums.ProblemTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 题目详情
 * @Author: CCB
 * @Date: 2023/2/14 22:38
 */
@Data
@ApiModel("题目详情")
public class ProblemBO {

    @ApiModelProperty("题目id")
    private Long id;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("题型: " + ProblemTypeEnum.KEY_VALUE)
    private Integer type;

    @ApiModelProperty("选项集合")
    private List<ChoiceBO> choiceList;

    @ApiModelProperty("答案")
    private String answer;

}
