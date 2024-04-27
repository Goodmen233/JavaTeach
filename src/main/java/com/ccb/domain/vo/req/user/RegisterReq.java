package com.ccb.domain.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 注册详情入参
 * @Author: CCB
 * @Date: 2023/2/9 13:23
 */
@Data
@ApiModel("注册详情入参")
public class RegisterReq {

    @ApiModelProperty("注册邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String password;
}
