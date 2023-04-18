package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 课程表
 * @Author: CCB
 * @Date: 2023/2/14 10:20
 */
@Data
@ApiModel("课程信息")
@Table(name = "t_course")
public class CoursePO implements Serializable {

    private static final long serialVersionUID = 2194887695902534207L;

    /**
    * 课程id
    */
    @ApiModelProperty("课程id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 名称
    */
    @ApiModelProperty("名称")
    private String name;

    /**
    * 介绍
    */
    @ApiModelProperty("介绍")
    private String introduce;

    /**
    * 课程人数
    */
    @ApiModelProperty("课程人数")
    private Integer capacity;

    /**
    * 教师id
    */
    @ApiModelProperty("教师id")
    private Long teacherId;

}
