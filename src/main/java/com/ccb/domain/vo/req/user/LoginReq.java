package com.ccb.domain.vo.req.user;

import com.ccb.common.enums.UserTypeEnum;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 登录入参
 * @Author: CCB
 * @Date: 2023/2/9 11:18
 */
@Data
@ApiModel("登录入参（邮箱或者手机号任选一种）")
public class LoginReq {

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

    @NotNull
    @ApiModelProperty("密码")
    private String password;

    @NotNull
    @ApiModelProperty("用户类型: " + UserTypeEnum.KEY_VALUE)
    private Integer type;
}
