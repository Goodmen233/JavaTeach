package com.ccb.domain.vo.resp.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 登录出参
 * @Author: CCB
 * @Date: 2023/2/9 11:41
 */
@Data
@ApiModel("登录出参")
public class LoginResp {

    @ApiModelProperty("身份凭证")
    private String token;
}
