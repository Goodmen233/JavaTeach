package com.ccb.domain.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 修改密码入参
 * @Author: CCB
 * @Date: 2023/2/9 14:37
 */
@Data
@ApiModel("修改密码入参")
public class UpdatePasswordReq {

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("验证码")
    private String verificationCode;

    @ApiModelProperty("新密码")
    private String newPwd;
}
