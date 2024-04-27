package com.ccb.domain.vo.req.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 审核通过入参
 * @Author: CCB
 * @Date: 2023/2/9 17:23
 */
@Data
@ApiModel("审核通过入参")
public class AuditPassReq {

    @ApiModelProperty("待审核人id")
    private Long id;
}
