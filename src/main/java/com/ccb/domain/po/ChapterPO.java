package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 章节表
 * @Author: CCB
 * @Date: 2023/2/14 10:03
 */
@Data
@ApiModel("章节信息")
public class ChapterPO implements Serializable {

    private static final long serialVersionUID = -5080105898033638961L;

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

    /**
    * 关联章节内容id
    */
    @ApiModelProperty("关联章节内容id")
    private Long chapterContentId;

}
