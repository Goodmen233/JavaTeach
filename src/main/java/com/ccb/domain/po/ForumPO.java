package com.ccb.domain.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 讨论表
 * @Author: CCB
 * @Date: 2023/2/14 10:44
 */
@Data
@ApiModel("讨论信息")
public class ForumPO implements Serializable {

    private static final long serialVersionUID = -1209598272149537591L;

    /**
    * 交流id
    */
    @ApiModelProperty("交流id")
    private Long id;

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
