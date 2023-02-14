package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 分享表
 * @Author: CCB
 * @Date: 2023/2/14 11:30
 */
@Data
@ApiModel("分享信息")
public class SharePO implements Serializable {

    private static final long serialVersionUID = 8624430963158295658L;

    /**
    * 分享id
    */
    @ApiModelProperty("分享id")
    private Long id;

    /**
    * 标题
    */
    @ApiModelProperty("标题")
    private String title;

    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String content;

    /**
    * 发布时间
    */
    @ApiModelProperty("发布时间")
    private Date publishDatetime;

    /**
    * 关联课程id
    */
    @ApiModelProperty("关联课程id")
    private Long courseId;

}
