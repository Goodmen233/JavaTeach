package com.ccb.domain.vo.resp.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 章节内容出参
 * @Author: CCB
 * @Date: 2023/2/9 14:47
 */
@Data
@ApiModel("章节内容出参")
public class ChapterContentResp {

    @ApiModelProperty("课程内容id")
    private Long contentId;

    @ApiModelProperty("课程内容")
    private String content;

}
