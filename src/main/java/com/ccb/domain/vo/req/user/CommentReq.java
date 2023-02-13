package com.ccb.domain.vo.req.user;

import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description: 评论详情入参
 * @Author: CCB
 * @Date: 2023/2/13 21:55
 */
@Data
@ApiModel("评论详情入参")
public class CommentReq extends PageReq {

    private Long linkId;

    private Integer linkType;

}
