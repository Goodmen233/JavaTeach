package com.ccb.domain.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 评论删除入参
 * @Author: CCB
 * @Date: 2023/2/13 22:45
 */
@Data
@ApiModel("评论删除入参")
public class CommentDeleteReq {

    /**
     * 评论id
     */
    @ApiModelProperty("评论id")
    private Long id;
}
