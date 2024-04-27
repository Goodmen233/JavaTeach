package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 作业/练习表
 * @Author: CCB
 * @Date: 2023/2/14 10:22
 */
@Data
@ApiModel("作业/练习表")
@Table(name = "t_exercise")
public class ExercisePO implements Serializable {

    private static final long serialVersionUID = 2554051715295764640L;

    /**
    * 作业/练习id
    */
    @ApiModelProperty("作业/练习id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
    * 结束后是否查看答案 0:是, 1:否
    */
    @ApiModelProperty("结束后是否查看答案 0:是, 1:否")
    private Integer showAnswer;

    /**
    * 关联课程id
    */
    @ApiModelProperty("关联课程id")
    private Long courseId;

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
