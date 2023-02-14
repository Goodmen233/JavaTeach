package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 标签关联表
 * @Author: CCB
 * @Date: 2023/2/14 14:10
 */
@Data
@ApiModel("标签关联表")
public class TagLinkPO implements Serializable {

    private static final long serialVersionUID = -7867625060204454949L;

    /**
    * 标签关联id
    */
    @ApiModelProperty("标签关联id")
    private Long id;

    /**
    * 标签id
    */
    @ApiModelProperty("标签id")
    private Long tagId;

    /**
    * 关联id
    */
    @ApiModelProperty("关联id")
    private Long linkId;

}
