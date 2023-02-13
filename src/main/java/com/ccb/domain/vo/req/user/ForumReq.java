package com.ccb.domain.vo.req.user;

import com.ccb.domain.common.CommonReq;
import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 讨论列表入参
 * @Author: CCB
 * @Date: 2023/2/9 15:05
 */
@Data
@ApiModel("讨论列表入参")
public class ForumReq extends PageReq {

    @ApiModelProperty("课程id")
    private Long courseId;

}