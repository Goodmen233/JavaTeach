package com.ccb.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 通用分页入参
 * @Author: CCB
 * @Date: 2023/2/7 14:39
 */
@Data
@ApiModel(value = "通用分页入参")
public class PageReq {

    /**
     * 页数
     */
    @ApiModelProperty(value = "页数")
    private Integer pageNo;

    /**
     * 页大小
     */
    @ApiModelProperty(value = "页大小")
    private Integer pageSize;
}
