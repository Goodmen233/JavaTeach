package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description: 分享发布入参
 * @Author: CCB
 * @Date: 2023/2/10 10:44
 */
@Data
@ApiModel("分享发布入参")
public class SharePublishReq {

    @ApiModelProperty("分享id")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("关联课程id")
    private Long courseId;

    @ApiModelProperty("标签名称集合")
    private List<String> tagList;

}
