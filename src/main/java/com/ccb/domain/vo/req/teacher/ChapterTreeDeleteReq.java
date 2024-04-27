package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 章节树删除入参
 * @Author: CCB
 * @Date: 2023/2/10 10:38
 */
@Data
@ApiModel("章节树删除入参")
public class ChapterTreeDeleteReq {

    @ApiModelProperty("章节id")
    private Long id;
}
