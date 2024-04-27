package com.ccb.domain.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 讨论发布入参
 * @Author: CCB
 * @Date: 2023/2/9 15:08
 */
@Data
@ApiModel("讨论发布入参")
public class ForumPublishReq {

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

    /**
     * 关联课程id
     */
    @ApiModelProperty("关联课程id")
    private Long courseId;
}
