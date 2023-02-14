package com.ccb.domain.vo.req.user;

import com.ccb.common.enums.CommentLinkTypeEnum;
import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 评论详情入参
 * @Author: CCB
 * @Date: 2023/2/13 21:55
 */
@Data
@ApiModel("评论详情入参")
public class CommentReq extends PageReq {

    @ApiModelProperty("关联id")
    private Long linkId;

    @ApiModelProperty("关联类型: " + CommentLinkTypeEnum.KEY_VALUE)
    private Integer linkType;

}
