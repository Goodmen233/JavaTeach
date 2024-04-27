package com.ccb.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 请求必装参数
 * @Author: CCB
 * @Date: 2023/2/7 14:41
 */
@ApiModel(value = "请求必装参数")
@Data
public class CommonReq {

    /**
     * 登录凭证
     */
    @ApiModelProperty(value = "登录凭证",required = true)
    private String token;
}
