package com.ccb.domain.po;

import com.ccb.common.enums.ProblemTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 题目表
 * @Author: CCB
 * @Date: 2023/2/14 10:49
 */
@Data
@ApiModel("题目表")
@Table(name = "t_problem")
public class ProblemPO implements Serializable {

    private static final long serialVersionUID = 7415147666016843449L;

    /**
    * 题目id
    */
    @ApiModelProperty("题目id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String content;

    /**
    * 题型 0:单选 1:多选 2:判断 3:填空
    */
    @ApiModelProperty("题型: " + ProblemTypeEnum.KEY_VALUE)
    private Integer type;

    /**
    * 作业/练习id
    */
    @ApiModelProperty("作业/练习id")
    private Long exerciseId;

    /**
    * 答案
    */
    @ApiModelProperty("答案")
    private String answer;

}
