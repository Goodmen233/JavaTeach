package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 章节内容新增/修改入参
 * @Author: CCB
 * @Date: 2023/2/10 10:39
 */
@Data
@ApiModel("章节内容新增/修改入参")
public class ChapterContentModifyReq {

    @ApiModelProperty("课程内容id")
    private Long contentId;

    @ApiModelProperty("课程内容")
    private String content;

    /*
    章节树id
    fileIdList;
     */
}
