package com.ccb.domain.vo.req.user;

import com.ccb.domain.common.CommonReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 章节树入参
 * @Author: CCB
 * @Date: 2023/2/9 14:43
 */
@Data
@ApiModel("章节树入参")
public class ChapterTreeReq {

    @ApiModelProperty("课程id")
    private Long courseId;
}
