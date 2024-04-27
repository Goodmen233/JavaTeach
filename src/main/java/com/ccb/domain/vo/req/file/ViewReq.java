package com.ccb.domain.vo.req.file;

import com.ccb.common.enums.FileLinkTypeEnum;
import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 文件列表入参
 * @Author: CCB
 * @Date: 2023/2/10 18:21
 */
@Data
@ApiModel("文件列表入参")
public class ViewReq extends PageReq {

    @ApiModelProperty("关联id")
    private Long linkId;

    @ApiModelProperty("关联类型: " + FileLinkTypeEnum.KEY_VALUE)
    private Integer linkType;
}
