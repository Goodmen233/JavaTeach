package com.ccb.domain.vo.req.user;

import com.ccb.common.enums.BooleanEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 注册信息提交入参
 * @Author: CCB
 * @Date: 2023/2/9 13:55
 */
@Data
@ApiModel("注册信息提交入参")
public class RegisterSubmitReq {

    @ApiModelProperty("注册id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("班级id(学生必传，教师不用传)")
    private Long classId;

    @ApiModelProperty("是否是老师注册: " + BooleanEnum.KEY_VALUE)
    private Integer isTeacher;
}
