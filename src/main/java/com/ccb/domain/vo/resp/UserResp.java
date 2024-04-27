package com.ccb.domain.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 用户信息
 * @Author: CCB
 * @Date: 2023/2/14 15:36
 */
@Data
@ApiModel("用户信息")
public class UserResp {

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 头像链接
     */
    @ApiModelProperty("头像链接")
    private String avatarUrl;
}
