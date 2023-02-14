package com.ccb.domain.vo.req.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 课程删除入参
 * @Author: CCB
 * @Date: 2023/2/10 10:35
 */
@Data
@ApiModel("课程删除入参")
public class CourseDeleteReq {

    @ApiModelProperty("课程id")
    private Long id;
}
