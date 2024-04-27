package com.ccb.domain.vo.req.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 审核详情入参
 * @Author: CCB
 * @Date: 2023/2/9 17:21
 */
@Data
@ApiModel("审核详情入参")
public class AuditDetailReq {

    @ApiModelProperty("待审核人id")
    private Long id;
}
