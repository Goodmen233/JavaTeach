package com.ccb.domain.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 讨论删除入参
 * @Author: CCB
 * @Date: 2023/2/9 15:05
 */
@Data
@ApiModel("讨论删除入参")
public class ForumDeleteReq {

    /**
     * 讨论id
     */
    @ApiModelProperty("讨论id")
    private Long id;
}
