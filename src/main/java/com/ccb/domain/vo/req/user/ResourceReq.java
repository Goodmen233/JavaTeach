package com.ccb.domain.vo.req.user;

import com.ccb.domain.common.CommonReq;
import com.ccb.domain.common.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 课程资料入参
 * @Author: CCB
 * @Date: 2023/2/9 15:03
 */
@Data
@ApiModel("课程资料入参")
public class ResourceReq extends PageReq {

    @ApiModelProperty("课程id")
    private Long courseId;

}
