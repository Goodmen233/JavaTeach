package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 分享删除入参
 * @Author: CCB
 * @Date: 2023/2/10 10:45
 */
@Data
@ApiModel("分享删除入参")
public class ShareDeleteReq {

    @ApiModelProperty("分享id")
    private Long id;
}
