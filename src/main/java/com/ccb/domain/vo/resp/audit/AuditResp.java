package com.ccb.domain.vo.resp.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 审核列表出参
 * @Author: CCB
 * @Date: 2023/2/9 17:17
 */
@Data
@ApiModel("审核列表出参")
public class AuditResp {

    @ApiModelProperty("待审核人id")
    private Long id;

    @ApiModelProperty("待审核人name")
    private String name;
}
