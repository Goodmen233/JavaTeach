package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 章节树修改入参
 * @Author: CCB
 * @Date: 2023/2/10 10:37
 */
@Data
@ApiModel("章节树修改入参")
public class ChapterTreeModifyReq {

    /**
     * 章节id
     */
    @ApiModelProperty("章节id")
    private Long id;

    /**
     * 章节编号
     */
    @ApiModelProperty("章节编号")
    private String no;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 上级章节id
     */
    @ApiModelProperty("上级章节id")
    private Long superId;

    /**
     * 关联课程id
     */
    @ApiModelProperty("关联课程id")
    private Long courseId;
}
