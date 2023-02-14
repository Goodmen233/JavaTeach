package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description: 课程发布/修改入参
 * @Author: CCB
 * @Date: 2023/2/10 10:34
 */
@Data
@ApiModel("课程发布/修改入参")
public class CoursePublishReq {

    @ApiModelProperty("课程id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("课程人数")
    private Integer capacity;

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("文件id集合")
    private List<Long> fileIdList;
}
