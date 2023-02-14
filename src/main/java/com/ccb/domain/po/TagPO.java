package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 标签表
 * @Author: CCB
 * @Date: 2023/2/14 14:09
 */
@Data
@ApiModel("标签信息")
public class TagPO implements Serializable {

    private static final long serialVersionUID = 2309001460041878342L;
    /**
    * 标签id
    */
    @ApiModelProperty("标签id")
    private Long id;

    /**
    * 名称
    */
    @ApiModelProperty("名称")
    private String name;

}
