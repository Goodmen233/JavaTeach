package com.ccb.domain.vo.resp.student;

import com.ccb.domain.po.ClassPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 学生个人中心出参
 * @Author: CCB
 * @Date: 2023/2/9 17:46
 */
@Data
@ApiModel("学生个人中心出参")
public class PersonalCenterResp {

    @ApiModelProperty("学生id")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像id")
    private Long avatarId;

    @ApiModelProperty("头像url")
    private String avatarUrl;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("班级信息")
    private ClassPO clazz;
}
