package com.ccb.domain.po;

import com.ccb.common.enums.ScoreLinkTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 学生成绩表
 * @Author: CCB
 * @Date: 2023/2/14 13:30
 */
@Data
@ApiModel("学生成绩信息")
public class StudentScorePO implements Serializable {

    private static final long serialVersionUID = 3064058067999478085L;
    /**
    * 学生成绩id
    */
    @ApiModelProperty("学生成绩id")
    private Long id;

    /**
    * 学生id
    */
    @ApiModelProperty("学生id")
    private Long studentId;

    /**
    * 关联id
    */
    @ApiModelProperty("关联id")
    private Long linkId;

    /**
    * 关联类型
    */
    @ApiModelProperty("关联类型: " + ScoreLinkTypeEnum.KEY_VALUE)
    private Integer linkType;

    /**
    * 成绩
    */
    @ApiModelProperty("成绩")
    private Integer score;

}
