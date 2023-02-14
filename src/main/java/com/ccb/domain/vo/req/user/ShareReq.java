package com.ccb.domain.vo.req.user;

import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 分享页面入参
 * @Author: CCB
 * @Date: 2023/2/10 11:25
 */
@Data
@ApiModel("分享页面入参")
public class ShareReq extends PageReq {

    /**
     * 关联课程id
     */
    @ApiModelProperty("关联课程id")
    private Long courseId;
}
