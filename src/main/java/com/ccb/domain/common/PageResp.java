package com.ccb.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @Description: 分页通用出参
 * @Author: CCB
 * @Date: 2023/2/14 09:52
 */
@Data
@RequiredArgsConstructor
@ApiModel("分页通用出参")
public class PageResp<T> {

    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("数据集合")
    private List<T> rows;

}
