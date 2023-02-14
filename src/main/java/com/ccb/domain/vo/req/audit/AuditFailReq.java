package com.ccb.domain.vo.req.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 审核不通过入参
 * @Author: CCB
 * @Date: 2023/2/9 17:31
 */
@Data
@ApiModel("审核不通过入参")
public class AuditFailReq {

    @ApiModelProperty("待审核人id")
    private Long id;
}
