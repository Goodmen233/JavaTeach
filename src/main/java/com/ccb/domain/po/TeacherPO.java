package com.ccb.domain.po;

import com.ccb.common.enums.AuditEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description: 教师表
 * @Author: CCB
 * @Date: 2023/2/14 14:12
 */
@Data
@ApiModel("教师信息")
@Table(name = "t_teacher")
public class TeacherPO implements Serializable {

    private static final long serialVersionUID = 2776557383202405382L;

    /**
    * 教师id
    */
    @ApiModelProperty("教师id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
