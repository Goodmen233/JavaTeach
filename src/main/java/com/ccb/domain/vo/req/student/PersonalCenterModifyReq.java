package com.ccb.domain.vo.req.student;

import com.ccb.domain.common.CommonReq;
import com.ccb.domain.po.ClassPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 学生个人中心修改
 * @Author: CCB
 * @Date: 2023/2/9 18:02
 */
@Data
@ApiModel("学生个人中心修改")
public class PersonalCenterModifyReq {

    @ApiModelProperty("学生id")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像id")
    private Long avatarId;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("班级id")
    private Long classId;
}
