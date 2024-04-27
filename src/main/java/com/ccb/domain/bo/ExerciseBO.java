package com.ccb.domain.bo;

import com.ccb.common.enums.BooleanEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 作业/练习信息
 * @Author: CCB
 * @Date: 2023/2/14 15:13
 */
@Data
@ApiModel("作业/练习信息")
public class ExerciseBO {

    /**
     * 作业/练习id
     */
    @ApiModelProperty("作业/练习id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 结束后是否查看答案
     */
    @ApiModelProperty("结束后是否查看答案: " + BooleanEnum.KEY_VALUE)
    private Integer showAnswer;

    /**
     * 学生：已完成未完成情况；老师：完成人数/班级人数
     */
    @ApiModelProperty("学生：已完成未完成情况；老师：完成人数/班级人数")
    private String mark;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endTime;
}
