package com.ccb.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 题目详情
 * @Author: CCB
 * @Date: 2023/2/14 22:39
 */
@Data
@ApiModel("题目详情")
public class ChoiceBO {

    @ApiModelProperty("序号")
    private String no;

    @ApiModelProperty("内容")
    private String content;

}
