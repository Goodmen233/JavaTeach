package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 班级表
 * @Author: CCB
 * @Date: 2023/2/14 10:09
 */
@Data
@ApiModel("班级信息")
public class ClassPO implements Serializable {

    private static final long serialVersionUID = 2437622835104271524L;
    /**
    * 班级id
    */
    @ApiModelProperty("班级id")
    private Long id;

    /**
    * 名称
    */
    @ApiModelProperty("名称")
    private String name;

    /**
    * 教师id
    */
    @ApiModelProperty("教师id")
    private Long teacherId;

}
