package com.ccb.domain.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 通用分页
 * @Author: CCB
 * @Date: 2023/3/27 15:23
 */
@Data
public class PageBO {

    /**
     * 页数
     */
    private Integer pageNo;

    /**
     * 页大小
     */
    private Integer pageSize;
}
