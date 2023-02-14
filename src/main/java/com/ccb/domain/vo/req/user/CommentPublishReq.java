package com.ccb.domain.vo.req.user;

import com.ccb.common.enums.CommentLinkTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 评论发布入参
 * @Author: CCB
 * @Date: 2023/2/13 22:43
 */
@Data
@ApiModel("评论发布入参")
public class CommentPublishReq {

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

    /**
     * 关联id
     */
    @ApiModelProperty("关联id")
    private Long linkId;

    /**
     * 关联类型
     */
    @ApiModelProperty("关联类型: " + CommentLinkTypeEnum.KEY_VALUE)
    private Integer linkType;
}
