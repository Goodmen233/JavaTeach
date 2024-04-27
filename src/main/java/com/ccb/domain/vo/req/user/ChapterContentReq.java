package com.ccb.domain.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 章节内容入参
 * @Author: CCB
 * @Date: 2023/2/9 14:46
 */
@Data
@ApiModel("章节内容入参")
public class ChapterContentReq {

    @ApiModelProperty("章节内容id")
    private Long chapterContentId;
}
