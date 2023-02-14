package com.ccb.domain.vo.resp.audit;

import com.ccb.common.enums.AuditEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 审核详情出参
 * @Author: CCB
 * @Date: 2023/2/9 17:21
 */
@Data
@ApiModel("审核详情出参")
public class AuditDetailResp {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("班级id-学生才有")
    private Long classId;

    @ApiModelProperty("班级名称-学生才有")
    private String className;

    @ApiModelProperty("审核状态:" + AuditEnum.KEY_VALUE)
    private Integer audit;
}
