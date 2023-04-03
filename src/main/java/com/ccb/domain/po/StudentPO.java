package com.ccb.domain.po;

import com.ccb.common.enums.AuditEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 学生表
 * @Author: CCB
 * @Date: 2023/2/14 11:36
 */
@Data
@ApiModel("学生信息")
public class StudentPO extends UserPO implements Serializable {

    private static final long serialVersionUID = -2882016843530189777L;

    /**
    * 学生id
    */
    @ApiModelProperty("学生id")
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
    * 密码
    */
    @ApiModelProperty("密码")
    private String password;

    /**
    * 班级id
    */
    @ApiModelProperty("班级id")
    private Long classId;

    /**
    * 审核标记
    */
    @ApiModelProperty("审核标记: " + AuditEnum.KEY_VALUE)
    private Integer audit;

    /**
     * 审核人手机号
     */
    @ApiModelProperty("审核人手机号")
    private String auditPhone;

}
