package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 章节内容删除入参
 * @Author: CCB
 * @Date: 2023/2/10 10:40
 */
@Data
@ApiModel("章节内容删除入参")
public class ChapterContentDeleteReq {

    @ApiModelProperty("课程内容id")
    private Long id;
}
