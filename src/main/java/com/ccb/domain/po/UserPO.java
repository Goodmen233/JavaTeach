package com.ccb.domain.po;

import com.ccb.common.enums.AuditEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 用户PO
 * @Author: CCB
 * @Date: 2023/4/3 21:19
 */
@Data
public class UserPO {

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
     * 介绍
     */
    @ApiModelProperty("介绍")
    private String introduce;

    /**
     * 研究方向
     */
    @ApiModelProperty("研究方向")
    private String researchDirections;

    /**
     * 审核人手机号
     */
    @ApiModelProperty("审核人手机号")
    private String auditPhone;
}
